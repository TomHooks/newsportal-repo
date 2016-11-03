package by.pvt.maruk.newsportal.beans;

import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by yura on 07.06.2016.
 */
@Entity
@Table(name = "NEWS")
public class New implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private int id;

    @Column(name = "NEWS_TITLE")
    private String newsTitle;

    @Column(name = "NEWS_CONTENT")
    @Type(type = "text")
    private String newsContent;

    @Column(name = "NEWS_DATE")
    @Temporal(TemporalType.DATE)
    private Date newsDate;

    @ManyToOne
    @JoinColumn(name = "F_USERS_ID")
    private User user;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNewsTitle() {
        return newsTitle;
    }

    public void setNewsTitle(String newsTitle) {
        this.newsTitle = newsTitle;
    }

    public String getNewsContent() {
        return newsContent;
    }

    public void setNewsContent(String newsContent) {
        this.newsContent = newsContent;
    }

    public Date getNewsDate() {
        return newsDate;
    }

    public void setNewsDate(Date newsDate) {
        this.newsDate = newsDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        New aNew = (New) o;

        if (newsTitle != null ? !newsTitle.equals(aNew.newsTitle) : aNew.newsTitle != null) return false;
        if (newsContent != null ? !newsContent.equals(aNew.newsContent) : aNew.newsContent != null) return false;
        return newsDate != null ? newsDate.equals(aNew.newsDate) : aNew.newsDate == null;

    }

    @Override
    public int hashCode() {
        int result = newsTitle != null ? newsTitle.hashCode() : 0;
        result = 31 * result + (newsContent != null ? newsContent.hashCode() : 0);
        result = 31 * result + (newsDate != null ? newsDate.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return newsDate + " " + newsTitle;
    }
}
