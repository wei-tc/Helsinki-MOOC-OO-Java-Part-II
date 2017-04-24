/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reference;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import reference.comparator.FilmComparator;
import reference.comparator.PersonComparator;
import reference.domain.Film;
import reference.domain.Person;
import reference.domain.Rating;

/**
 *
 * @author W
 */
public class Reference {

    private RatingRegister register;

    public Reference(RatingRegister register) {
        this.register = register;

    }

    public Film recommendFilm(Person viewer) {
        //  if seen no films, recommend top rated film
        if (register.getPersonalRatings(viewer).isEmpty()) {
            List<Film> films = new ArrayList<Film>(register.filmRatings().keySet());
            Collections.sort(films, new FilmComparator(register.filmRatings()));
            return films.get(0);
        }
        
        //  is there a film positively similar reviewers have seen and reviewed 
        //  positively, that the viewer has not seen?
        //  generate list of positively similar reviewers sorted in descending 
        //  order of similarity
        List<Person> reviewersSortedBySimilarity = reviewersSortBySimilarity(viewer);
        
        //  return positively reviewed unseen film from descending similarity 
        //  ordered list of positively similar reviewers
        return getRecommendedFilm(viewer, reviewersSortedBySimilarity);
    }
    
    private List<Person> reviewersSortBySimilarity(Person viewer) {
        //  get positively similar reviewers
        Map<Person, Integer> reviewerSimilarity = reviewerSimilarity(register.getPersonalRatings(viewer));
        
        //  sort in descending order of similarity list of positively
        //  similar reviewers
        List<Person> similarReviewers = new ArrayList<Person>(reviewerSimilarity.keySet());
        Collections.sort(similarReviewers, new PersonComparator(reviewerSimilarity));
        
        //  return sorted list of positively similar reviewers 
        return similarReviewers;
    }
    
    private Map<Person, Integer> reviewerSimilarity(Map<Film, Rating> filmRatings) {
        Map<Person, Integer> reviewerSimilarity = new HashMap<Person, Integer>();
        
        //  try to find positively similar reviewers to the viewer
        for (Person reviewer : register.reviewers()) {
            int similarity = 0;
            
            for (Film film : filmRatings.keySet()) {
                // similarity for each film = reviewer's rating * viewer's rating                
                similarity += filmRatings.get(film).getValue() * register.getRating(reviewer, film).getValue();
            }
            
            //  only include positively similar reviewers
            if (similarity > 0) {
                reviewerSimilarity.put(reviewer, similarity);
            }
        }
        
        //  return list of positively similar reviewers
        return reviewerSimilarity;
    }
    
    private Film getRecommendedFilm(Person viewer, List<Person> reviewersSortedBySimilarity) {
        Map<Film, Rating> viewersSeenFilms = register.getPersonalRatings(viewer);
        
        //  from a list of positively similar reviewers sorted in descending 
        //  order of similarity, try to find any positively reviewed film unseen 
        //  by the viewer in a list of films positively reviewed
        for (Person reviewer : reviewersSortedBySimilarity) {
            //  if recommending a film to the viewer, the viewer is not a 'reviewer'
            if (reviewer == viewer) {
                continue;
            }
            
            //  recommend positive film not seen by the viewer
            for (Film film : register.getPersonalRatings(reviewer).keySet()) {
                //  do not recommend films already seen by the viewer
                if (viewersSeenFilms.containsKey(film)) { 
                    continue;
                }
                
                //  recommend positively reviewed film
                if (register.getPersonalRatings(reviewer).get(film).getValue() > 1) {
                    return film;
                }
            }
        }
        
        //  no positively reviewed film by a similar reviewer that has not been
        //  seen by the viewer exists
        return null;
    }     
}
