
/*
--add-exports java.base/sun.nio.ch=ALL-UNNAMED
*/
// scalastyle:off println

// $example on$
import org.apache.spark.graphx.{GraphLoader, PartitionStrategy}
// $example off$
import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.functions._
import org.apache.spark.sql.expressions.Window
/** LAB 4
 * {{{
 *
 *    val graph = GraphLoader.edgeListFile(sc, "C:/Users/mykol/Downloads/graph for LR4.txt", canonicalOrientation = false)
 *    .partitionBy(PartitionStrategy.RandomVertexCut)
 *    // Find the triangle count for each vertex
 *    val triCounts = graph.triangleCount().vertices
 *    // Sum the triangle counts and divide by 3 to get the total number of unique triangles
 *    val totalTriangles = triCounts.map(_._2).reduce(_ + _) / 3
 *    println(s"Total number of triangles: $totalTriangles")
 *   }}}
 */

object main {
  def main(args: Array[String]): Unit = {
    // Creates a SparkSession.
    val spark = SparkSession
      .builder()
      .appName(s"${this.getClass.getSimpleName}")
      .master("local[*]")
      .config("spark.driver.extraJavaOptions", "--add-opens java.base/java.nio=ALL-UNNAMED --add-opens java.base/sun.nio.ch=ALL-UNNAMED")
      .getOrCreate()
    val sc = spark.sparkContext

//    val graph = GraphLoader.edgeListFile(sc, "C:/Users/mykol/Downloads/graph for LR4.txt", canonicalOrientation = false)
//        .partitionBy(PartitionStrategy.RandomVertexCut)
//        // Find the triangle count for each vertex
//       val triCounts = graph.triangleCount().vertices
//        // Sum the triangle counts and divide by 3 to get the total number of unique triangles
//       val totalTriangles = triCounts.map(_._2).reduce(_ + _) / 3
//        println(s"Total number of triangles: $totalTriangles")
    import spark.implicits._
    // Шлях до каталогу з текстовими файлами
    val dataPath = "C:/Users/mykol/Downloads/news20/20_newsgroup/talk.religion.misc"
    // Функція для обробки тексту: видаляє небажані символи, переводить у нижній регістр
    def cleanText(text: String): String = {
      text.toLowerCase
        .replaceAll("(?i)path:.*", "")
        .replaceAll("(?i)newsgroups:.*", "")
        .replaceAll("(?i)writes:.*", "")

        .replaceAll("'","\'")
        .replaceAll("[^a-z']", " ")
    }
    // Зчитування всіх файлів з каталогу
    val files = sc.wholeTextFiles(dataPath + "/*")
      .map { case (filePath, content) =>
        val filename = filePath.split("/").last.split("\\.").head
        val cleanedContent = cleanText(content)
        (filename, cleanedContent)
      }.toDF("docId", "content")

    // Розбиття контенту на слова і фільтрація
    val words = files
      .select($"docId", explode(split($"content", "\\s+")).as("word"))
      .filter($"word".rlike("^[a-z']+$"))

    // Обчислення інвертованого індексу
    val invertedIndex = words
      .groupBy("word")
      .agg(
        count("*").as("total_count"),
        collect_set("docId").as("documents")
      )
      .select(
        $"word",
        $"total_count",
        concat_ws(" ", $"documents").as("doc_list")
      )
//    invertedIndex.show(10)
    invertedIndex.coalesce(1)
        .write
        .mode("overwrite")
        .option("header", "true")
        .csv("E:/Parallel-and-distributed-computing/Lab4/MyOut")
       // $example on$
    // $example off$
    spark.stop()
  }
}
// scalastyle:on println
