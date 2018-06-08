import java.util

/**
  * Created by SANGJIN-NAM on 2018-06-05.
  */
class TRIX {

  def upperThrough(trix: util.LinkedList[Double]): Boolean = {
    if (trix.get(trix.size - 2) < 0) {
      if (trix.get(trix.size - 1) > 0) return true
    }
    return false
  }

  def lowerThrough(trix: util.LinkedList[Double]): Boolean = {
    if (trix.get(trix.size - 2) > 0) {
      if (trix.get(trix.size - 1) < 0) return true
    }
    return false
  }


}
