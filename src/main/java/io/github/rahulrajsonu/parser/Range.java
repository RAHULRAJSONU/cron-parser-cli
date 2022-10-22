package io.github.rahulrajsonu.parser;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Range extends io.github.rahulrajsonu.parser.Base {

  public Range(io.github.rahulrajsonu.segment.Base segment) {
    super(segment);
  }

  @Override
  public List<Integer> generatePossibilities() {
    List<Integer> rangeLimits = List.of(this.segment.getExpression().split("-")).stream()
      .map(Integer::valueOf).collect(
        Collectors.toList());

    if (rangeLimits.size() != 2) {
      throw new RuntimeException(
        "Range does not have valid expression : " + this.segment.getExpression());
    }

    if (getMin(rangeLimits) < this.segment.getMinimum()) {
      throw new RuntimeException(
        "Range minimum is not valid. Given : " + rangeLimits.get(0) + " Min allowed : "
          + this.segment.getMinimum());
    }

    if (getMin(rangeLimits) > this.segment.getMaximum()) {
      throw new RuntimeException(
        "Range minimum is not valid. Given : " + rangeLimits.get(0) + " Max allowed : "
          + this.segment.getMaximum());
    }

    if (getMax(rangeLimits) > this.segment.getMaximum()) {
      throw new RuntimeException(
        "Range maximum is not valid. Given : " + rangeLimits.get(1) + " Max allowed : "
          + this.segment.getMaximum());
    }

    return getRange(rangeLimits.get(0),rangeLimits.get(1),this.segment.getMinimum(),this.segment.getMaximum());
  }

  private int getMin(List<Integer> range){
    return range.stream().min((i,j)->i-j).get();
  }

  private int getMax(List<Integer> range){
    return range.stream().max((i,j)->i-j).get();
  }

  private List<Integer> getRange(int start, int stop,int min, int max){
    int i=start;
    int step = 0;
    if(start < stop)
      step = stop-start+1;
    else
      step = (max-start+2)+(stop-min);
    List<Integer> range = new ArrayList<>();
    while (step > 0){
      range.add(i);
      if(i==max){
        i=min-1;
      }
      i++;
      step--;
    }
    return range;
  }

}
