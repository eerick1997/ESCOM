package Objects;

/**Class User contains information that we can get using
 * the Google account, this information can be:
 * name, email, profile photo, id of google, ..., etc**/
public class User {

    //Variables
    private String name, email, nick_name, profile_img;
    private float n_qualifiers, sum_qualifications;
    private int state;

    public User() {
    }

    public User(String name, String email, String nick_name, float n_qualifiers, float sum_qualifications, String profile_img, int state) {
        this.name = name;
        this.email = email;
        this.nick_name = nick_name;
        this.profile_img = profile_img;
        this.n_qualifiers = n_qualifiers;
        this.sum_qualifications = sum_qualifications;
        this.state = state;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNick_name() {
        return nick_name;
    }

    public void setNick_name(String nick_name) {
        this.nick_name = nick_name;
    }

    public String getProfile_img() {
        return profile_img;
    }

    public void setProfile_img(String profile_img) {
        this.profile_img = profile_img;
    }

    public float getN_qualifiers() {
        return n_qualifiers;
    }

    public void setN_qualifiers(float n_qualifiers) {
        this.n_qualifiers = n_qualifiers;
    }

    public float getSum_qualifications() {
        return sum_qualifications;
    }

    public void setSum_qualifications(float sum_qualifications) {
        this.sum_qualifications = sum_qualifications;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }


    /*
    //Constructor
    *User constructor needs six parameters
     * 1. Name: The name of this user this is provided by his/her google account
     * 2. Email: This parameter is provided by his/her google account
     * 3. Nick name: this need to be unique and created by each user
     * 4. Number of qualifiers: This parameter is used to calculate the rank of each user
     * 5. Sum of qualifications: this parameter has all the qualifications of the users
     * 6. Qualification: this parameter has the **/


    /*public User(String name, String email, String nick_name,
                float n_qualifiers, float sum_qualifications,
                String profile_img, int state){
        //Initializing our global private variables
        this.name = name;
        this.email = email;
        this.nick_name = nick_name;
        this.n_qualifiers = n_qualifiers;
        this.sum_qualifications = sum_qualifications;
        this.profile_img = profile_img;
        this.state = state;
    }*/



    /**--------------- GETTERS ---------------**/


    /*
    public String getName(){
        return this.name;
    }

    public String getEmail(){
        return this.email;
    }

    public String getNick_name() {
        return this.nick_name;
    }

    public float getN_qualifiers(){
        return this.n_qualifiers;
    }

    public float getSum_qualifications(){
        return this.sum_qualifications;
    }

    public String getProfile_img(){
        return this.profile_img;
    }

    public int getState(){
        return this.state;
    }*/

    /**-------------- SETTERS ---------------**/
    /*
    public void setName(String name){
        this.name = name;
    }

    public void setEmail(String email){
        this.email = email;
    }

    public void setNick_name(String nick_name){
        this.nick_name = nick_name;
    }

    public void setNqualifiers(Float n_qualifiers){
        this.n_qualifiers = n_qualifiers;
    }

    public void setSum_qualifications(Float sum_qualifications){
        this.sum_qualifications = sum_qualifications;
    }

    public void setetProfile_img(String profile_img){
        this.profile_img = profile_img;
    }

    public void setetState(int state){
        this.state = state;
    }
    */
}
