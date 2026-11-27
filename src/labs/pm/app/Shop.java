/*
 * Copyright (c) 2026.
 * This program is free software: you can redistribute it and/or modify it under the terms of the GNU General Public License as published by the Free Software Foundation, either version 3 of the License, or (at your option) any later version.
 * This program is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU General Public License for more details.
 * You should have received a copy of the GNU General Public License along with this program.  If not, see http://www.gnu.org/licenses/.
 */

package labs.pm.app;

import labs.pm.data.*;

import javax.swing.plaf.basic.BasicRadioButtonMenuItemUI;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;

/**
 * {@code Shop} class represents am aplication that ,anages Products
 * @version 4.0
 * @author oracle
 **/
public class Shop {

        public static void main(String[] args) {

            try {
                ProductManager pm = new ProductManager("es-ES");
                System.setProperty("java.locale-providers","HOST,CLDR");

//                Product p1 = pm.createProduct(101, "Tea", BigDecimal.valueOf(1.99), Rating.NOT_RATED);
                pm.parseProduct("D,101,Tea,1.99,0,25/11/26");

                pm.printProductReport(101);
                pm.parseReview("101,4,Nice hot cup of tea");
                pm.parseReview("101,1,Meh");
                pm.parseReview("101,1,No esta tan bueno");
                pm.parseReview("101,5,Is the best hot cup of tea i drink in all my life");
                pm.parseReview("101,3,Not bad");
                pm.parseReview("101,4,Really good");
//                p1 = pm.reviewProduct(101, Rating.FOUR_STAR, "Nice hot cup of tea");
//                p1 = pm.reviewProduct(p1, Rating.ONE_STAR, "Meh");
//                p1 = pm.reviewProduct(p1, Rating.ONE_STAR, "No esta tan bueno");
//                p1 = pm.reviewProduct(p1, Rating.FIVE_STAR, "Is the best hot cup of tea i drink in all my life");
//                p1 = pm.reviewProduct(p1, Rating.THREE_STAR, "Not bad");
//                p1 = pm.reviewProduct(p1, Rating.FOUR_STAR, "Really good");

                pm.printProductReport(101);

                pm.parseProduct("D,102,Coffee,1.99,0,25/11/26");

                pm.parseReview("102,3,Coffee was ok");
                pm.parseReview("102,1,Where is the milk?!");
                pm.parseReview("102,5,It's perfect with ten spoons of sugar!");

                pm.printProductReport(102);

                pm.parseProduct("F,103,Cake,3.99,0,25/11/26");

                pm.parseReview("103,5,Very nice cake");
                pm.parseReview("103,4,Good, but I've expected more chocolate");
                pm.parseReview("103,5,This cake is perfect!");

                pm.printProductReport(103);

                pm.parseProduct("F,104,Cookie,2.99,0,25/11/26");

                pm.parseReview("104,3,Just another cookie");
                pm.parseReview("104,3,Ok");

                pm.printProductReport(104);

                pm.parseProduct("D,105,Hot Chocolate,2.50,0,25/11/26");

                pm.parseReview("105,4,Tasty!");
                pm.parseReview("105,4,No bad at all");

                pm.printProductReport(105);

                pm.parseProduct("F,106,Chocolate,2.50,0,28/11/26");

                pm.parseReview("106,2,Too sweet");
                pm.parseReview("106,3,Better then cookie");
                pm.parseReview("106,2,Too bitter");
                pm.parseReview("106,1,I don't get it!");

                pm.printProductReport(106);


                Comparator<Product> priceSorter = (pr1, pr2) ->
                        pr2.getPrice().compareTo(pr1.getPrice());

                Comparator<Product> ratingSorter = (pr1, pr2) ->
                        pr2.getRating().ordinal() - pr1.getRating().ordinal();

                pm.printProducts(p -> p.getPrice().floatValue() < 3,
                        priceSorter);
                pm.printProducts(p -> p.getPrice().floatValue() < 4,
                        priceSorter.thenComparing(ratingSorter).reversed());

                pm.getDiscounts().forEach((k,v) -> System.out.println(k + "\t" + v));

            } catch (ProductManagerException e) {
                    Throwable cause = e.getCause();
            }

        }

}