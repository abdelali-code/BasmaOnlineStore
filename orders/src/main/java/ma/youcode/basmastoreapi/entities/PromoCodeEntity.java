package ma.youcode.basmastoreapi.entities;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.sql.Date;

@Entity
@Table(name = "promo_code")
public class PromoCodeEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_promo_code", nullable = false, updatable = false)
    private Integer idPromoCode;
    @NotNull
    private String code;
    @NotNull
    private Float percentage;
    @NotNull
    @Column(name = "start_date")
    private Date startDate;
    @NotNull
    @Column(name = "end_date")
    private Date endDate;

    public PromoCodeEntity() {
    }

    public PromoCodeEntity(String code, Float percentage, Date startDate, Date endDate) {
        this.code = code;
        this.percentage = percentage;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public PromoCodeEntity(Integer idPromoCode, String code, Float percentage, Date startDate, Date endDate) {
        this.idPromoCode = idPromoCode;
        this.code = code;
        this.percentage = percentage;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public Integer getIdPromoCode() {
        return idPromoCode;
    }

    public void setIdPromoCode(Integer idPromoCode) {
        this.idPromoCode = idPromoCode;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Float getPercentage() {
        return percentage;
    }

    public void setPercentage(Float percentage) {
        this.percentage = percentage;
    }
}
