public class Vam {

    String shomare_hessab;
    int darsad_sood;
    double meghdar_vam;
    VamType vamType;
    double meghdar_har_ghest;

    public Vam(String shomare_hessab, int darsad_sood,
               double meghdar_vam, VamType vamType) {
        this.shomare_hessab = shomare_hessab;
        this.darsad_sood = darsad_sood;
        this.meghdar_vam = meghdar_vam;
        this.vamType = vamType;
    }

    public String getShomare_hessab() {
        return shomare_hessab;
    }

    public void setShomare_hessab(String shomare_hessab) {
        this.shomare_hessab = shomare_hessab;
    }

    public int getDarsad_sood() {
        return darsad_sood;
    }

    public void setDarsad_sood(int darsad_sood) {
        this.darsad_sood = darsad_sood;
    }

    public double getMeghdar_vam() {
        return meghdar_vam;
    }

    public void setMeghdar_vam(double meghdar_vam) {
        this.meghdar_vam = meghdar_vam;
    }

    public VamType getVamType() {
        return vamType;
    }

    public void setVamType(VamType vamType) {
        this.vamType = vamType;
    }
}
