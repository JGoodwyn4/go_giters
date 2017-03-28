
public class Constraint
{
    private String[] colleges;
    private String[] classStatus;
    private boolean registered;

    Constraint(String[] collegeConstraint, String[] classConstraint, boolean regConstraint)
    {
	colleges = collegeConstraint;
	classStatus = classConstraint;
	registered = regConstraint;
    }

    // Get and Set methods for every variable
    
    public String[] getCollegeConstraints()
    {
	return colleges;
    }
}
