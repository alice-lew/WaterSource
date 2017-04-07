package com.tristenallen.watersource.model;

import android.location.Location;

import java.util.Date;
import java.util.Locale;

/**
 * Created by tristen on 3/10/17.
 * Stores information about a purity report.
 */
public class PurityReport {
    private final WaterPurity purity;
    private final int userID;
    private final Location location;
    private final Date timestamp;
    private final int reportNumber;
    private final int virusPPM;
    private final int contaminantPPM;

    /**
     * Generates a new SourceReport at the given location
     * with the given userID as its author and the given
     * WaterType and WaterQuality.
     *
     * Report ID numbers are passed in, but should be autogenerated by
     * their holding data structure, by convention.
     *
     * All data in a SourceReport is considered immutable.
     */
    PurityReport(int userID, Location location, WaterPurity purity, int reportNumber,
                 int virusPPM, int contaminantPPM) {
        this.userID = userID;
        this.location = location;
        this.purity = purity;
        this.virusPPM = virusPPM;
        this.contaminantPPM = contaminantPPM;
        this.reportNumber = reportNumber;
        this.timestamp = new Date();
    }

    /**
     * Returns the user ID that created this report.
     * @return int ID of the user that created this report.
     */
    @SuppressWarnings("unused") // necessary for future use cases
    public int getUserID() {
        return userID;
    }

    /**
     * Returns the purity of water considered in this report.
     * @return WaterPurity representing the type of water.
     */
    public WaterPurity getPurity() {
        return purity;
    }

    /**
     * Returns the ppm of the viruses in this water source.
     * @return int specifying the amount of viruses in this source, in ppm.
     */
    public int getVirusPPM() {
        return virusPPM;
    }

    /**
     * Returns the ppm of contaminants sin this water source.
     * @return int specifying the amount of contaminants in this source, in ppm.
     */
    public int getContaminantPPM() {
        return contaminantPPM;
    }

    /**
     * Returns the given location of this report.
     * @return Location of the water source.
     */
    public Location getLocation() {
        return location;
    }

    /**
     * Returns the time this report was generated.
     * @return Date representing the time this report was created.
     */
    public Date getTimestamp() {
        return timestamp;
    }

    /**
     * Returns the ID number of this report.
     * @return int representing the ID of this report.
     */
    public int getReportNumber() {
        return reportNumber;
    }

    @Override
    public String toString() {
        return "Report Number: " + reportNumber + "\n" + "Location: "
                + String.format(Locale.US, "%.2f",location.getLatitude()) + ", "
                + String.format(Locale.US, "%.2f",location.getLongitude()) + "\n"
                + "Water purity: " + purity.toString() + "\n" + "Virus PPM: " + virusPPM + "\n"
                + "Contaminant PPM: " + contaminantPPM
                + "\n" + "Created: " + timestamp;
    }
}
