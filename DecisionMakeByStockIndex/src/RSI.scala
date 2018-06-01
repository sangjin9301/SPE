import java.util.LinkedList

/**
  * Created by SANGJIN-NAM on 2018-06-01.
  */
class RSI {

  //////////
  //RS = 산출기간 동안 종가 상승분 평균 / 산출기간 동안 종가 하락분 평균
  //RSI = 100-(100/(1+RS))
  def getRSI(endPrice:LinkedList[Double]):Double={
    var upward:LinkedList[Double]
    var lowward:LinkedList[Double]
    for(i <- 1 to endPrice.size-1){
      if(endPrice.get(i)>endPrice.get(i-1))upward.add(endPrice.get(i)-endPrice.get(i-1))
    }
    for(i <- 1 to endPrice.size-1){
      if(endPrice.get(i)<endPrice.get(i-1))lowward.add(endPrice.get(i-1)-endPrice.get(i))
    }
    var sum=0
    upward.forEach(gap=>{
       sum += gap
    })
    var upward_avg = sum/(upward.size-1)

    sum=0
    lowward.forEach(gap=>{
      sum += gap
    })
    var lowward_avg = sum/(lowward.size-1)

    val rs = upward_avg/lowward_avg
    return 100 - ( 100 / (1 + rs))
  }

  def overheat(endPrice:LinkedList[Double]):Boolean={
    if(getRSI(endPrice)>70)return true
    else return false
  }

  def depression(endPrice:LinkedList[Double]):Boolean={
    if(getRSI(endPrice)<30)return true
    else return false
  }

}
