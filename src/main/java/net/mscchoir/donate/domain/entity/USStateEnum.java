/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.mscchoir.donate.domain.entity;

/**
 *
 * @author bossbabs
 */
public enum USStateEnum {

    Alabama("AL", "alabama"), Montana("MT", "montana"), Alaska("AK", "alaska"), Nebraska("NE", "nebraska"),
    Arizona("AZ", "arizona"), Nevada("NV", "nevada"), Arkansas("AR", "arkansas"), NewHampshire("NH", "new hampshire"),
    California("CA", "california"), NewJersey("NJ", "new jersey"), Colorado("CO", "colorado"), NewMexico("NM", "new mexico"),
    Connecticut("CT", "connecticut"), NewYork("NY", "new york"), Delaware("DE", "delaware"), NorthCarolina("NC", "north carolina"),
    Florida("FL", "florida"), NorthDakota("ND", "north dakota"), Georgia("GA", "georgia"), Ohio("OH", "ohio"), Hawaii("HI", "hawaii"),
    Oklahoma("OK", "oklahoma"), Idaho("ID", "idaho"), Oregon("OR", "oregon"), Illinois("IL", "illinois"), Pennsylvania("PA", "pennsylvania"),
    Indiana("IN", "indiana"), RhodeIsland("RI", "rhode island"), Iowa("IA", "iowa"), SouthCarolina("SC", "south carolina"), Kansas("KS", "kansas"),
    SouthDakota("SD", "south dakota"), Kentucky("KY", "kentucky"), Tennessee("TN", "tennessee"), Louisiana("LA", "louisiana"), Texas("TX", "texas"),
    Maine("ME", "maine"), Utah("UT", "utah"), Maryland("MD", "maryland"), Vermont("VT", "vermont"), Massachusetts("MA", "massachusetts"),
    Virginia("VA", "virginia"), Michigan("MI", "michigan"), Washington("WA", "washington"), Minnesota("MN", "minnesota"),
    WestVirginia("WV", "west virginia"), Mississippi("MS", "mississippi"), Wisconsin("WI", "wisconsin"), Missouri("MO", "missouri"), Wyoming("WY", "wyoming");
    
    private final String code;
    private final String name;
    
    private USStateEnum(String code, String name) {
        this.code = code;
        this.name = name;
    }

    public String getName() {
        return name;
    }
    public String getCode() {
        return code;
    }
}
