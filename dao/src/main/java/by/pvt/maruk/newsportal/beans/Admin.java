package by.pvt.maruk.newsportal.beans;

/**
 * Created by yura on 15.05.2016.
 */
public class Admin {
    private String adminName;
    private String adminPassword;

    public String getAdminName() {
        return adminName;
    }

    public void setAdminName(String adminName) {
        this.adminName = adminName;
    }

    public String getAdminPassword() {
        return adminPassword;
    }

    public void setAdminPassword(String adminPassword) {
        this.adminPassword = adminPassword;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Admin admin = (Admin) o;

        return adminName != null ? adminName.equals(admin.adminName) : admin.adminName == null;

    }

    @Override
    public int hashCode() {
        return adminName != null ? adminName.hashCode() : 0;
    }
}
