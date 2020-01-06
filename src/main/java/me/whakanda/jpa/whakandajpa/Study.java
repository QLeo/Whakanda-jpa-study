package me.whakanda.jpa.whakandajpa;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Study {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    // @ManyToOne의 기준은 밸류를 보았을 때 collection이 아니면 ManyToOne 이다
    // 양방향일 때는 foreign key를 가진쪽이 오너다!! 즉 @ManyToOne 설정된 쪽이 오너임
    @ManyToOne
    private Account owner;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Account getOwner() {
        return owner;
    }

    public void setOwner(Account owner) {
        this.owner = owner;
    }
}
