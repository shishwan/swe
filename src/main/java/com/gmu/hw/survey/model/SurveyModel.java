package com.gmu.hw.survey.model;

import jakarta.persistence.*;

import java.util.Date;


@Entity
@Table(name = "surveys")
public class SurveyModel {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @Column(name="first_name",nullable = false)
        private String firstName;

        @Column(name="last_name",nullable = false)
        private String lastName;

        @Column(name="street_address",nullable = false)
        private String streetAddress;

        @Column(name="city",nullable = false)
        private String city;

        @Column(name="state",nullable = false)
        private String state;

        @Column(name="zip",nullable = false)
        private String zip;

        @Column(name="telephone_number",nullable = false)
        private String telephoneNumber;

        @Column(name="email",nullable = false)
        private String email;

        @Column(name="dos",nullable = false)
        private Date dateOfSurvey;


        @Column(name = "liked_about_campus",nullable = false)
        private String likedAboutCampus;

        @Column(name = "interest_source",nullable = false)
        private String interestSource;

        @Column(name = "likelihood_To_Recommend",nullable = false)
        private String likelihoodToRecommend;

        @Column(name = "additional_comments",length = 10000)
        private String additionalComments;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getStreetAddress() {
        return streetAddress;
    }

    public void setStreetAddress(String streetAddress) {
        this.streetAddress = streetAddress;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getTelephoneNumber() {
        return telephoneNumber;
    }

    public void setTelephoneNumber(String telephoneNumber) {
        this.telephoneNumber = telephoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getDateOfSurvey() {
        return dateOfSurvey;
    }

    public void setDateOfSurvey(Date dateOfSurvey) {
        this.dateOfSurvey = dateOfSurvey;
    }

    public String getLikedAboutCampus() {
        return likedAboutCampus;
    }

    public void setLikedAboutCampus(String likedAboutCampus) {
        this.likedAboutCampus = likedAboutCampus;
    }

    public String getInterestSource() {
        return interestSource;
    }

    public void setInterestSource(String interestSource) {
        this.interestSource = interestSource;
    }

    public String getLikelihoodToRecommend() {
        return likelihoodToRecommend;
    }

    public void setLikelihoodToRecommend(String likelihoodToRecommend) {
        this.likelihoodToRecommend = likelihoodToRecommend;
    }

    public String getAdditionalComments() {
        return additionalComments;
    }

    public void setAdditionalComments(String additionalComments) {
        this.additionalComments = additionalComments;
    }
}

