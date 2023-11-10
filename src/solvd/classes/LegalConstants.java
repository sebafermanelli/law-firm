package solvd.classes;

public final class LegalConstants {
  public static final String LEGAL_SYSTEM_NAME = "SF LawFirm System";
  private static final int LAWYER_FEE_PERCENTAGE = 20;

  public static void displayLegalSystemInfo() {
    System.out.println("Legal System: " + LEGAL_SYSTEM_NAME);
    System.out.println("Lawyer Fee Percentage: " + LAWYER_FEE_PERCENTAGE);
  }

  public static String getLegalSystemName() {
    return LEGAL_SYSTEM_NAME;
  }

  public static int getLawyerFeePercentage() {
    return LAWYER_FEE_PERCENTAGE;
  }
}
