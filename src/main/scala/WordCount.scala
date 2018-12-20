import org.apache.spark.{SparkConf, SparkContext}


object WordCount {
  def main(args: Array[String]): Unit = {
    val conf = new SparkConf().setAppName("wordcount")
    val sc = new SparkContext(conf)

    val input = sc.textFile("/home/anyi/text.txt")

    val lines = input.flatMap(line=>line.split(" "))
    val count = lines.map(word=>(word, 1)).reduceByKey{case (x, y)=>x+y}

    val output = count.saveAsTextFile("/home/anyi/sss")
  }
}
