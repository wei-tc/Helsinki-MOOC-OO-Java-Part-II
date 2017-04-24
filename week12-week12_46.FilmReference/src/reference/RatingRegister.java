/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reference;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import reference.domain.Film;
import reference.domain.Person;
import reference.domain.Rating;

/**
 *
 * @author W
 */
public class RatingRegister {

    private Map<Film, List<Rating>> filmRatings;
    private Map<Person, Map<Film, Rating>> reviewerRatings;

    public RatingRegister() {
        this.filmRatings = new HashMap<Film, List<Rating>>();
        this.reviewerRatings = new HashMap<Person, Map<Film, Rating>>();
    }

    public void addRating(Film film, Rating rating) {
        if (!filmRatings.containsKey(film)) {
            filmRatings.put(film, new ArrayList<Rating>());
        }

        filmRatings.get(film).add(rating);
    }

    public List<Rating> getRatings(Film film) {
        return filmRatings.get(film);
    }

    public Map<Film, List<Rating>> filmRatings() {
        return filmRatings;
    }

    public void addRating(Person person, Film film, Rating rating) {
        if (!reviewerRatings.containsKey(person)) {
            reviewerRatings.put(person, new HashMap<Film, Rating>());
            reviewerRatings.get(person).put(film, rating);
            addRating(film, rating);
        } else if (!reviewerRatings.get(person).containsKey(film)) {
            reviewerRatings.get(person).put(film, rating);
            addRating(film, rating);
        }
    }

    public Rating getRating(Person person, Film film) {
        if (!reviewerRatings.containsKey(person)) {
            return Rating.NOT_WATCHED;
        } else if (!reviewerRatings.get(person).containsKey(film)) {
            return Rating.NOT_WATCHED;
        } 
        
        return reviewerRatings.get(person).get(film);
    }

    public Map<Film, Rating> getPersonalRatings(Person person) {
        if (!reviewerRatings.containsKey(person)) {
            return new HashMap();
        }
        
        return reviewerRatings.get(person);
    }

    public List<Person> reviewers() {
        return new ArrayList<Person>(reviewerRatings.keySet());
    }
}
