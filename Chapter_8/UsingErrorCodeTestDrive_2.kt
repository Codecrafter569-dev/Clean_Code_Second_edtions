fun deleteFileBad(path: String): Int{
  return if(path.isNotBlank()) 0 else 1
}

fun useErrorCode(){
  if(deleteFileBad("data.txt") == 0){
    println("Delete successfully ...")
  }else{
    println("Failed to delete")
  }
}

class FileDeleteException(message: String) : Exception(message)

fun deleteFile(path: String) {
    if (path.isBlank()) throw FileDeleteException("Invalid path")
    println("Deleted $path successfully")
}

fun useException() {
    try {
        deleteFile("data.txt")
    } catch (e: FileDeleteException) {
        println("Failed to delete: ${e.message}")
    }
}

fun main() {
    useErrorCode()
    useException()
}