import java.util.ArrayList;

public class ReviewCollector {
  private ArrayList<ProductReview> reviewList;
  private ArrayList<String> productList;

  public ReviewCollector() {
    reviewList = new ArrayList<ProductReview>();
    productList = new ArrayList<String>();
  }

  public void addReview(ProductReview prodReview) {
    reviewList.add(prodReview);
    if (!(productList.contains(prodReview.getName()))) {
      productList.add(prodReview.getName());
      return;
    }
  }

  public int getNumGoodReviews(String prodName) {
    if (!productList.contains(prodName)) {
      return 0;
    }
    int goodReviews = 0;
    for (ProductReview productReview : reviewList) {
      if (productReview.getReview().contains("best")) {
        goodReviews++;
      }
    }
    return goodReviews;
  }

  public static void main(String[] args) {
    ProductReview a = new ProductReview("a", "best");
    ProductReview b = new ProductReview("b", "review");
    ProductReview c = new ProductReview("a", "Best");
    ReviewCollector collector = new ReviewCollector();
    collector.addReview(a);
    collector.addReview(b);
    collector.addReview(c);
    System.out.println(collector.getReviewList());
    System.out.println(collector.getProductList());
    System.out.println(collector.getNumGoodReviews("a"));
  }

  public ArrayList<ProductReview> getReviewList() {
    return reviewList;
  }

  public ArrayList<String> getProductList() {
    return productList;
  }
}
