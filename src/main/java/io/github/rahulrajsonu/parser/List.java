package io.github.rahulrajsonu.parser;

import java.util.stream.Collectors;

public class List extends io.github.rahulrajsonu.parser.Base {

  public List(io.github.rahulrajsonu.segment.Base segment) {
    super(segment);
  }

  @Override
  public java.util.List<Integer> generatePossibilities() {
    String[] list = this.segment.getExpression().split(",");

    int numOfVVariable = (segment.getMaximum()- segment.getMinimum())+1;
    if (list.length > numOfVVariable) {
      throw new RuntimeException(
        "List does not have valid expression : " + this.segment.getExpression());
    }

    return java.util.List.of(list).stream()
      .flatMap(l -> {
        try {
          return io.github.rahulrajsonu.parser.Base.get(new io.github.rahulrajsonu.segment.Base(l) {
            @Override
            public Integer getMinimum() {
              return segment.getMinimum();
            }

            @Override
            public Integer getMaximum() {
              return segment.getMaximum();
            }

            @Override
            public String getExpression() {
              return l;
            }
          }).generatePossibilities().stream();
        } catch (Exception e) {
          throw new RuntimeException(e.getMessage());
        }
      }).distinct().sorted().collect(Collectors.toList());
  }
}
