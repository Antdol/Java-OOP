import java.util.*;

class TokenizableString {
  private String contenu;
  private int from;
  private int len;

  public TokenizableString(String phrase) {
    contenu = phrase;
  }

  private boolean nextToken() {
    if (contenu.length() == 0) return false;
    from = from + len;
    while (from < contenu.length() && contenu.charAt(from) == ' ') {
      ++from;
    }
    int i = 0;
    while (from + i < contenu.length() && contenu.charAt(from + i) != ' ') {
      ++i;
    }
    len = i;
    if (len == 0) {
      return false;
    } else {
      return true;
    }
  }

  public void tokenize() {
    System.out.println("Les mots de " + contenu + " sont :");
    while (nextToken()) {
      System.out.print("\'");
      for (int i = from; i < from + len; ++i) {
        System.out.print(contenu.charAt(i));
      }
      System.out.println("\'");
    }
  }
}

public class Segmentation {

  private static Scanner scanner = new Scanner(System.in);
  public static void main(String[] args) {
    String phrase;
    System.out.print("Entrez une chaine : ");
    phrase = scanner.nextLine();
    TokenizableString toToken = new TokenizableString(phrase);
    toToken.tokenize();
  }
}
