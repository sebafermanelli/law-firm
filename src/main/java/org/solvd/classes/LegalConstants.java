package org.solvd.classes;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public final class LegalConstants {
  public static final String LEGAL_SYSTEM_NAME = LawFirm.getInstance().getName();
  private static final int LAWYER_FEE_PERCENTAGE = 20;

  private static final Logger LOGGER = LogManager.getLogger(LegalConstants.class);

  public static void displayLegalSystemInfo() {
    LOGGER.info("Legal System: " + LEGAL_SYSTEM_NAME);
    LOGGER.info("Lawyer Fee Percentage: " + LAWYER_FEE_PERCENTAGE);
  }

  public static String getLegalSystemName() {
    return LEGAL_SYSTEM_NAME;
  }

  public static int getLawyerFeePercentage() {
    return LAWYER_FEE_PERCENTAGE;
  }
}
