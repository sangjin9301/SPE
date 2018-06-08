import java.util

/**
  * Created by SANGJIN-NAM on 2018-06-05.
  */
class Stochastic {

  def isLower20percent(K:Double):Boolean={
    if(K<20)return true
    return false
  }

  def isUpper80percent(K:Double):Boolean={
    if(K>80)return true
    return false
  }

  def upperThrough(K_list:util.LinkedList[Double], D_list:util.LinkedList[Double]):Boolean={
    var n = K_list.size
    var gradient = (K_list.getLast - K_list.getFirst) / n

    if(K_list.get(K_list.size-2)<D_list.get(D_list.size-1)){
      if(K_list.get(K_list.size-1)>D_list.get(D_list.size-1)){
        if(gradient>0)return true
      }
    }return false
  }

  def lowerThrough(K_list:util.LinkedList[Double], D_list:util.LinkedList[Double]):Boolean={
    var n = K_list.size
    var gradient = (K_list.getLast - K_list.getFirst) / n

    if(K_list.get(K_list.size-2)>D_list.get(D_list.size-1)){
      if(K_list.get(K_list.size-1)<D_list.get(D_list.size-1)){
        if(gradient<0)return true
      }
    }return false
  }

}
