package me.whakanda.jpa.whakandajpa;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Account {

    @Id
    @GeneratedValue
    private Long id;

    private String userName;

    private String passWord;

    @Temporal(TemporalType.DATE)
    private Date created = new Date();

    @Transient
    private String transitionType;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "street", column = @Column(name = "home_street"))
    })
    private Address address;

    // @OneToMany, @ManyToOne 만 설정했을 때는 두 개의 단방향이 된다
    // 양방향으로 하기 위해서는 @OneToMany에다가 mappedBy (@ManyToOne이라고 정의된 변수이름)를 설정해야 한다
    @OneToMany(mappedBy = "owner")
    private Set<Study> studies = new HashSet<>();


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public String getTransitionType() {
        return transitionType;
    }

    public void setTransitionType(String transitionType) {
        this.transitionType = transitionType;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Set<Study> getStudies() {
        return studies;
    }

    public void setStudies(Set<Study> studies) {
        this.studies = studies;
    }

    public void addStudy(Study study) {
        // 아래의 코드는 옵션이다.. 넣어도 그만 안 넣어도 그만
        // 하지만 객체지향적으로 생각하면 둘다 넣어줘야 한다
        this.getStudies().add(study);

        // 양방향이기 때문에 둘 다 데이터를 넣어줘야 한다 (왜? study가 주인이기 때문에)
        study.setOwner(this);
    }

    public void removeStudy(Study study) {
        this.getStudies().remove(study);
        study.setOwner(null);
    }
}
