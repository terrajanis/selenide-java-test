package pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.$x;

public class InterestsPage {

    private SelenideElement
            webSeries = $x("//div[@data-name=\"web series\"]"),
            anime = $x("//div[@data-name=\"anime\"]"),
            fashion = $x("//div[@data-name=\"fashion\"]"),
            travel = $x("//div[@data-name=\"travel\"]"),
            technology = $x("//div[@data-name=\"technology\"]"),
            nextButtonCounter = $x("//span[@class=\"next-button-counter-container\"]"),
            nextButton = $x("//span[contains(., \"Next\")]");

    ElementsCollection tagNames = $$(byXpath("//span[@class=\"tag-name\"]"));

    public void fillInterests() {
        fillInterest(webSeries, "веб-сериалы", 0, "4", true);
        fillInterest(anime, "аниме", 1, "3",  true);
        fillInterest(fashion, "мода", 2, "2", true);
        fillInterest(travel, "путешествия", 3,  "1", true);
        fillInterest(technology, "технологии", 4, "0", false);
        nextButton.click();
    }

    public void fillInterest(SelenideElement element, String interestName, Integer position, String interestsNumber, Boolean isNotFinished) {
        element.click();
        tagNames.get(position).shouldHave(text(interestName));
        if (isNotFinished) {
            nextButtonCounter.shouldHave(text(interestsNumber));
        }
    }
}
