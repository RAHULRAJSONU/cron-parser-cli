package io.github.rahulrajsonu.segment;

public class Hour extends Base {
  public Hour(String expression) {
    super(expression);
    this.minimum = 0;
    this.maximum = 23;
  }
}
