package io.github.rahulrajsonu.parser;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Any extends io.github.rahulrajsonu.parser.Base {

  public Any(io.github.rahulrajsonu.segment.Base segment) {
    super(segment);
  }

  @Override
  public List<Integer> generatePossibilities() {
    return Arrays.stream(IntStream.range(this.segment.getMinimum(), this.segment.getMaximum() + 1).toArray()).boxed().collect(
      Collectors.toList());
  }
}
