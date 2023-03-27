import java.util.ArrayList;

/**
 * Object that represents a name for a baby. Includes the sex of the name
 * and birth data for the number of babies born with that name in a
 * particular year.
 * @author __________
 */
public class BabyName {
    
    // TODO 1: Write the code below this line.
    private String name;
    private GenderOfName gender;
    private ArrayList<Integer> birthCounts;
    private ArrayList<Integer> years;
    
    public BabyName(String name, GenderOfName gender){
        this.name = name;
        this.gender = gender;
        this.birthCounts = new ArrayList<Integer>();
        this.years = new ArrayList<Integer>();
    }
    //Accessor Methods
    public String getName(){return this.name;}
    public GenderOfName getGender(){return this.gender;}
    public ArrayList<Integer> getBirthCounts(){return this.birthCounts;}
    public ArrayList<Integer> getYears(){return this.years;}

    //Mutator Methods
    public void setGender(GenderOfName gender){
        this.gender = gender;
    }

    public void addData(int numOfBirths, int correspondingYear){
        //if nothing is in the ArrayList
        if(years.size() == 0){
            years.add(correspondingYear);
            birthCounts.add(numOfBirths);
        }
        //if something is in the ArrayList
        else{
            int currentSize = years.size();
            for(int i = 0; i < currentSize; i++){
                //to max
                if(correspondingYear > years.get(i) && i == years.size()-1){
                    years.add(correspondingYear);
                    birthCounts.add(numOfBirths);
                }

                else if (correspondingYear < years.get(i)){
                    years.add(i,correspondingYear);
                    birthCounts.add(i,numOfBirths);
                }
            }
        }
    }
    //overloaded
    public void addData(ArrayList<Integer> numOfBirthsList, ArrayList<Integer> yearsList){
        for(int i = 0; i < yearsList.size(); i++){
            addData(numOfBirthsList.get(i), yearsList.get(i));
        }
    }

    /**
     *
     * @param targetYear the year user wants to find
     * @return index of year, returns -1 if not found
     */
    public int findYearIndex(int targetYear){
        for(int i = 0; i < this.years.size(); i++){
            if(this.years.get(i) == targetYear){return i;}
        }
        return -1;
    }
    /**
     * Formats the object as a String.
     * @return formatted String
     */
    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append("Name: " + name + "\nSex of Name: " + gender.toString().toLowerCase());
        for (int i = 0; i < years.size(); i++){
            if (i == 0){
                result.append("\nData: ");
            }
            result.append(String.format("(%d, %d), ", birthCounts.get(i), years.get(i)));
            if (i == years.size()-1){
                result.deleteCharAt(result.length()-2); // Remove extra space
            }
        }
        return result.toString();
    }
}