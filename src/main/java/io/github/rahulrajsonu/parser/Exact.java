package io.github.rahulrajsonu.parser;

import java.util.List;

public class Exact extends io.github.rahulrajsonu.parser.Base {

  public Exact(io.github.rahulrajsonu.segment.Base segment) {
    super(segment);
  }

  @Override
  public List<Integer> generatePossibilities() {
    Integer value = Integer.valueOf(this.segment.getExpression());
    if (value > this.segment.getMaximum()) {
      throw new RuntimeException("The value for segment is more than the maximum allowed");
    }

    if (value < this.segment.getMinimum()) {
      throw new RuntimeException("The value for segment is less than the minimum allowed");
    }

    return List.of(value);
  }
}
