/**
  * Created by SANGJIN-NAM on 2018-05-31.
  */

import java.util.LinkedList
class MovingAverage{

  //////////
  // When return-value is TRUE, Agent buys stocks
  def goldenCross(ma_yesterday:Double, ma_today:Double, openPrice: LinkedList[Double]):Boolean={
    var n = openPrice.size
    var gradient = (openPrice.getLast - openPrice.getFirst)/n
    var true_without_gradient = false

    if(ma_yesterday < openPrice.get(openPrice.size-2))
      if(ma_today > openPrice.get(openPrice.size-1))
        true_without_gradient = true

    if(true_without_gradient)
      if(gradient>=0)
        return true
    return false
  }
  //////////
  // When return-value is TRUE, Agent sells stocks
  def deadCross(ma_yesterday:Double, ma_today:Double, openPrice: LinkedList[Double]):Boolean={
    var n = openPrice.size
    var gradient = (openPrice.getLast - openPrice.getFirst)/n
    var true_without_gradient = false

    if(ma_yesterday > openPrice.get(openPrice.size-2))
      if(ma_today < openPrice.get(openPrice.size-1))
        true_without_gradient = true

    if(true_without_gradient)
      if(gradient<=0)
        return true
    return false
  }

  def temporaryDecline(ma_yesterday:Double, ma_today:Double, openPrice: LinkedList[Double]):Boolean={
    var n = openPrice.size
    var gradient = (openPrice.getLast - openPrice.getFirst)/n
    var ma_rise = false

    if(ma_yesterday < ma_today) ma_rise = true

    if(ma_rise){
      if(gradient<0) return true else return false
    }else return false
  }

  def temporaryRise(ma_yesterday:Double, ma_today:Double, openPrice: LinkedList[Double]):Boolean={
    var n = openPrice.size
    var gradient = (openPrice.getLast - openPrice.getFirst)/n
    var ma_decline = false

    if(ma_yesterday > ma_today) ma_decline = true

    if(ma_decline){
      if(gradient>0) return true else return false
    }else return false
  }
}
