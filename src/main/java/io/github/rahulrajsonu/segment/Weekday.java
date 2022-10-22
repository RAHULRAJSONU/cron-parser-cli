package io.github.rahulrajsonu.segment;

public class Weekday extends Base {
  public Weekday(String expression) {
    super(expression);
    this.minimum = 1;
    this.maximum = 7;
  }
}
