public class ProductReview {
  private String name;
  private String review;

  public String getName() {
    return name;
  }

  public String getReview() {
    return review;
  }

  public ProductReview(String name, String review) {
    this.name = name;
    this.review = review;
  }

  @Override
  public String toString() {
    return "ProductReview [name=" + name + ", review=" + review + "]";
  }
}
