import java.util

/**
  * Created by SANGJIN-NAM on 2018-06-01.
  */
class BollingerBand {

  // 60일간 (upper - lower)가 평균의 1/2보다 낮으면 추세변화가 있을 것으로 평가.

  def buyingSign(openPrice: util.LinkedList[Double], upper: util.LinkedList[Double], lower: util.LinkedList[Double]): Boolean = {
    var n = openPrice.size
    var gradient = (openPrice.getLast - openPrice.getFirst) / n

    var width_list: util.LinkedList[Double] = null
    var mean_width = 0

    for (i <- 0 to upper.size - 1) {
      width_list.add(upper.get(i) - lower.get(i))
    }

    width_list.forEach(width => {
      mean_width += width
    })
    mean_width = mean_width / width_list.size

    if (gradient > 0) {
      if (width_list.get(width_list.size - 1) < (mean_width / 3)) {
        return true
      }
    }
    return false
  }

  def sellingSign(openPrice: util.LinkedList[Double], upper: util.LinkedList[Double], lower: util.LinkedList[Double]): Boolean = {
    var n = openPrice.size
    var gradient = (openPrice.getLast - openPrice.getFirst) / n

    var width_list: util.LinkedList[Double] = null
    var mean_width = 0

    for (i <- 0 to upper.size - 1) {
      width_list.add(upper.get(i) - lower.get(i))
    }

    width_list.forEach(width => {
      mean_width += width
    })
    mean_width = mean_width / width_list.size

    if (gradient < 0) {
      if (width_list.get(width_list.size - 1) < (mean_width / 2)) {
        return true
      }
    }
    return false
  }

  def upperThrough(openPrice: util.LinkedList[Double], upper: util.LinkedList[Double], lower: util.LinkedList[Double]): Boolean = {
    var yesterday_price = openPrice.get(openPrice.size - 2)
    var today_price = openPrice.get(openPrice.size - 1)
    var ma = 0

    var isThrough: Boolean = null
    if (yesterday_price < upper.get(upper.size - 1)) {
      if (today_price > upper.get(upper.size - 1)) isThrough = true
      else isThrough = false
    }

    openPrice.forEach(price => {
      ma += price
    })
    ma = ma / openPrice.size


    if (isThrough) {
      if (lower.get(lower.size - 1) > ma) return true
    }
    return false
  }

  def lowerThrough(openPrice: util.LinkedList[Double], upper: util.LinkedList[Double], lower: util.LinkedList[Double]): Boolean = {
    var yesterday_price = openPrice.get(openPrice.size - 2)
    var today_price = openPrice.get(openPrice.size - 1)
    var ma = 0

    var isThrough: Boolean = null
    if (yesterday_price > upper.get(upper.size - 1)) {
      if (today_price < upper.get(upper.size - 1)) isThrough = true
      else isThrough = false
    }

    openPrice.forEach(price => {
      ma += price
    })
    ma = ma / openPrice.size


    if (isThrough) {
      if (upper.get(upper.size - 1) < ma) return true
    }
    return false
  }

}
