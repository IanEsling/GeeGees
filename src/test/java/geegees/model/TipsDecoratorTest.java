package geegees.model;

import geegees.model.Horse;
import geegees.model.TipsDecorator;
import org.jsoup.Jsoup;
import org.junit.Before;
import org.junit.Test;

import java.util.Collection;
import java.util.Map;

import static com.google.common.collect.Lists.newArrayList;
import static com.google.common.collect.Maps.newHashMap;
import static org.junit.Assert.assertEquals;

public class TipsDecoratorTest {

    Collection<Horse> horses;
    Map<String, Integer> expectedTips;

    @Before
    public void createExpectedTips(){
        expectedTips = newHashMap();
        expectedTips.put("Kingdom", 5);
        expectedTips.put("Cool Metallic", 1);
        expectedTips.put("Lucky Kitten", 0);
    }

    @Before
    public void createHorses() {
        horses = newArrayList();
        horses.add(new Horse("Kingdom", "11/1"));
        horses.add(new Horse("Cool Metallic", "12/1"));
        horses.add(new Horse("Lucky Kitten", "11/1"));
    }

    @Test
    public void shouldAddNumberOfTipsToHorse() {
        TipsDecorator decorator = new TipsDecorator(Jsoup.parseBodyFragment(getHorsesHtml()), horses);
        assertEquals("wrong number of horses", 3, decorator.getHorses().size());
        for (Horse horse : decorator.getHorses()) {
            assertEquals("wrong number of expectedTips", expectedTips.get(horse.getName()), horse.getTips());
        }
    }

    private String getHorsesHtml() {
        return "<table id=\"sc_sortBlock\" class=\"cardGrid cardSt\">\n" +
                " <colgroup>\n" +
                " <col class=\"trapCol\">\n" +
                " <col class=\"silkCol\">\n" +
                " <col class=\"stHorseCol\">\n" +
                " <col class=\"colB\">\n" +
                " <col class=\"stJTCol\">\n" +
                " <col>\n" +
                " <col>\n" +
                " </colgroup>\n" +
                " <thead id=\"sc_cardHead\" class=\"cardHead\">\n" +
                " <tr>\n" +
                " <th colspan=\"2\">\n" +
                " <span id=\"sc_sort-no\" onclick=\"sortBlock('no');\" onmouseover=\"$(this).addClass('hover');\" onmouseout=\"$(this).removeClass('hover');\" title=\"Sort runners by Number\">NO.</span>\n" +
                " <span id=\"sc_sort-draw\" onclick=\"sortBlock('draw');\" onmouseover=\"$(this).addClass('hover');\" onmouseout=\"$(this).removeClass('hover');\" title=\"Sort runners by Draw\">DRAW</span> <br><span class=\"noSorting\">FORM</span>\n" +
                " </th>\n" +
                " <th>\n" +
                " <span id=\"sc_sort-horse\" onclick=\"sortBlock('horse');\" onmouseover=\"$(this).addClass('hover');\" onmouseout=\"$(this).removeClass('hover');\" title=\"Sort runners by Horse's Name\">HORSE</span><br>\n" +
                " <span id=\"sc_sort-chance\" onclick=\"sortBlock('chance');\" onmouseover=\"$(this).addClass('hover');\" onmouseout=\"$(this).removeClass('hover');\" title=\"Sort runners by Win chance\">WIN CHANCE</span>\n" +
                " </th>\n" +
                " <th class=\"c\">\n" +
                " <span id=\"sc_sort-expectedTips\" class=\"tips\" onclick=\"sortBlock('expectedTips');\" onmouseover=\"$(this).addClass('hover');\" onmouseout=\"$(this).removeClass('hover');\" title=\"Sort runners by Tips\">TIPS</span><br>\n" +
                " <span id=\"sc_sort-rpr\" class=\"rpr\" title=\"Sort runners by Racing Post Rating\" onmouseout=\"$(this).removeClass('hover');\" onmouseover=\"$(this).addClass('hover');\" onclick=\"sortBlock('rpr');\">RPR</span>\n" +
                " <span id=\"sc_sort-ts\" class=\"ts\" title=\"Sort runners by Top Speed\" onmouseout=\"$(this).removeClass('hover');\" onmouseover=\"$(this).addClass('hover');\" onclick=\"sortBlock('ts');\">TS</span>\n" +
                " </th>\n" +
                " <th class=\"jt\">\n" +
                " <span id=\"sc_sort-trainer\" onclick=\"sortBlock('trainer');\" onmouseover=\"$(this).addClass('hover');\" onmouseout=\"$(this).removeClass('hover');\" title=\"Sort runners by Trainer's Name\">TRAINER <em>RTF%</em></span><br>\n" +
                " <span id=\"sc_sort-jockey\" onclick=\"sortBlock('jockey');\" onmouseover=\"$(this).addClass('hover');\" onmouseout=\"$(this).removeClass('hover');\" title=\"Sort runners by Jockey's Name\">JOCKEY</span>\n" +
                " </th>\n" +
                " <th class=\"awo\">\n" +
                " <span id=\"sc_sort-age\" title=\"Sort runners by Age\" onmouseout=\"$(this).removeClass('hover');\" onmouseover=\"$(this).addClass('hover');\" onclick=\"sortBlock('age');\">AGE</span> <span class=\"spr\">/</span>\n" +
                " <span id=\"sc_sort-wgt\" onclick=\"sortBlock('wgt');\" onmouseover=\"$(this).addClass('hover');\" onmouseout=\"$(this).removeClass('hover');\" title=\"Sort runners by Weight\">WGT</span><br>\n" +
                " <span id=\"sc_sort-or\" onclick=\"sortBlock('or');\" onmouseover=\"$(this).addClass('hover');\" onmouseout=\"$(this).removeClass('hover');\" title=\"Sort runners by OR\">OR</span>\n" +
                " \n" +
                " </th>\n" +
                " <th class=\"bk\">\n" +
                " <strong class=\"ewt\" id=\"each_way_container\">EACH-WAY <em><ins>1</ins>/<del>4</del></em> 1-2</strong>\n" +
                " <span id=\"sc_sort-B11\" class=\"active\" onclick=\"sortBlock('B11');\" onmouseover=\"$(this).addClass('hover');\" onmouseout=\"$(this).removeClass('hover');\" title=\"Sort runners by Ladbrokes price\">\n" +
                " <img src=\"http://ui.racingpost.com/release/v17/pic/ladbrokes-logos/card-logo.17.0.gif\" alt=\"Ladbrokes\" title=\"Ladbrokes\" width=\"63\" height=\"21\"> </span>\n" +
                " </th>\n" +
                " </tr>\n" +
                " </thead>\n" +
                "\n" +
                "\n" +
                " \n" +
                "\n" +
                " \n" +
                "\n" +
                " \n" +
                "\n" +
                " \n" +
                "\n" +
                " \n" +
                "\n" +
                " \n" +
                "\n" +
                " <tbody id=\"sc_61564720\">\n" +
                " <tr class=\"cr\">\n" +
                " <td class=\"t\">\n" +
                " <strong>1</strong><sup>3</sup> <em>73326</em>\n" +
                " </td>\n" +
                " <td class=\"s\">\n" +
                " <a href=\"http://www.racingpost.com/horses/owner_home.sd?owner_id=18339\" onclick=\"scorecards.send(&quot;owner_name&quot;);return Html.popup(this, {width:695, height:800})\" title=\"Full details about this OWNER\"><img src=\"http://images.racingpost.com/png_silks/9/3/3/18339.png\" class=\"iepng\" alt=\"Owner details\" title=\"Full details about this OWNER\" width=\"40\" height=\"29\"></a> </td>\n" +
                " \n" +
                " <td class=\"h\">\n" +
                " <div class=\"nm\">\n" +
                " <a href=\"http://www.racingpost.com/horses/horse_home.sd?race_id=565793&amp;r_date=2012-10-16&amp;horse_id=813959\" onclick=\"scorecards.send(&quot;horse_name&quot;);return Html.popup(this, {width:695, height:800})\" title=\"Full details about this HORSE\"><b>COOL METALLIC</b></a> <img src=\"http://ui.racingpost.com/ico/distance-bf.gif\" class=\"cdbf\" alt=\"\"> <span>\n" +
                " b </span>\n" +
                " \n" +
                " <a href=\"#\" id=\"sc_pencil_813959\" title=\"Show/Hide My Notes for this runner\"></a> </div>\n" +
                "\n" +
                " <div class=\"oddsBar\">\n" +
                " &nbsp; </div>\n" +
                " </td>\n" +
                " <td class=\"two c\">\n" +
                " <div class=\"tips\">1</div>\n" +
                " <div class=\"rpr\">89</div>\n" +
                " <div class=\"ts\">79 </div>\n" +
                " </td>\n" +
                " <td class=\"two jt\">\n" +
                " <div>\n" +
                " <a href=\"http://www.racingpost.com/horses/trainer_home.sd?trainer_id=1010\" onclick=\"scorecards.send(&quot;trainer_name&quot;);return Html.popup(this, {width:695, height:800})\" title=\"Full details about this TRAINER\">D K Weld</a><sup><span title=\"the percentage of the stable's runners that have Run To Form in the last 14 days, based on RPR\">35</span></sup> </div>\n" +
                " <div>\n" +
                " <span>DOUBTFUL</span> </div>\n" +
                " </td>\n" +
                " <td class=\"two awo\">\n" +
                " <div>\n" +
                " 2 &nbsp;\n" +
                " 9-5 </div>\n" +
                " <div>\n" +
                " 75 </div>\n" +
                " </td>\n" +
                " <td class=\"bk\" id=\"sc_61564720_bk\"><strong class=\"noBetting\">No betting</strong></td>\n" +
                " </tr>\n" +
                " <tr>\n" +
                " <td class=\"cardItemInfo\" colspan=\"7\">\n" +
                " <p class=\"diomed\">\n" +
                " These track conditions could hinder a few, proven on it so should play a part </p>\n" +
                " <div class=\"forms\">\n" +
                " <table class=\"grid smallSpaceGrid\">\n" +
                " <tbody><tr class=\"noSpace\">\n" +
                " <th class=\"v\">&nbsp;</th>\n" +
                " <th class=\"date\">DATE</th>\n" +
                " <th class=\"raceCond\">RACE CONDITIONS</th>\n" +
                " <th class=\"wgt\">WGT</th>\n" +
                " <th class=\"raceOut\">RACE OUTCOME</th>\n" +
                " <th class=\"jock\">JOCKEY</th>\n" +
                " <th class=\"num\">OR</th>\n" +
                " <th class=\"num\">TS</th>\n" +
                " <th class=\"num last\">RPR</th>\n" +
                " </tr>\n" +
                " <tr>\n" +
                " <td class=\"v\"><a href=\"#\" onclick=\"scorecards.sendSpecificDesc(&quot;ruk_video&quot;, &quot;183, 2012-08-04, 12:00&quot;);panels.mediaCentre.replayPopup($(this), 561559, 813959, '2012-08-04', 'RUK'); return false;\"><img src=\"http://ui.racingpost.com/release/v17/ico/video.17.0.gif\" alt=\"Video\" title=\"Video\"></a></td>\n" +
                " <td>\n" +
                " <a href=\"http://www.racingpost.com/horses/result_home.sd?race_id=561559&amp;r_date=2012-08-04&amp;popup=yes\" onclick=\"scorecards.send(561559);return Html.popup(this, {width:695, height:800})\" title=\"Irish Stallion Farms European Breeders Fund Nursery Handicap\">04Aug12</a> &nbsp;\n" +
                " </td>\n" +
                " <td>\n" +
                " <b class=\"black\">\n" +
                " <a href=\"http://www.racingpost.com/horses/course_home.sd?crs_id=183\" onclick=\"return Html.popup(this, {width:695, height:800})\" title=\"Course (Click to view details): right-handed, undulating, testing track (1m2f rectangle)\">Gal</a> 7Sft/Hy </b>\n" +
                " 2yHc 10K </td>\n" +
                " <td>8-13</td>\n" +
                " <td>\n" +
                " <b class=\"black\">6</b>/6 <a href=\"http://www.racingpost.com/horses/result_home.sd?race_id=561559&amp;r_date=&amp;popup=yes\" onclick=\"scorecards.send(561559);return Html.popup(this, {width:695, height:800})\" title=\"led early, raced in 2nd until entering final 2f, weakened in straight, eased\">(24L Cest Notre Gris 8-10)</a> 11/4F </td>\n" +
                " <td>\n" +
                " <a href=\"http://www.racingpost.com/horses/jockey_home.sd?jockey_id=11184\" onclick=\"scorecards.send(&quot;jockey_name&quot;);return Html.popup(this, {width:695, height:800})\" title=\"Full details about this JOCKEY\">Pat Smullen</a> </td>\n" +
                " <td class=\"num\">78</td>\n" +
                " <td class=\"num\"><span class=\"red bold\">*</span></td>\n" +
                " <td class=\"num last\"><span class=\"red bold\">*</span></td>\n" +
                " </tr>\n" +
                " <tr>\n" +
                " <td class=\"v\"><a href=\"#\" onclick=\"scorecards.sendSpecificDesc(&quot;ruk_video&quot;, &quot;185, 2012-07-16, 12:00&quot;);panels.mediaCentre.replayPopup($(this), 560635, 813959, '2012-07-16', 'RUK'); return false;\"><img src=\"http://ui.racingpost.com/release/v17/ico/video.17.0.gif\" alt=\"Video\" title=\"Video\"></a></td>\n" +
                " <td>\n" +
                " <a href=\"http://www.racingpost.com/horses/result_home.sd?race_id=560635&amp;r_date=2012-07-16&amp;popup=yes\" onclick=\"scorecards.send(560635);return Html.popup(this, {width:695, height:800})\" title=\"Irish Stallion Farms European Breeders Fund Median Auction Maiden\">16Jul12</a> &nbsp;\n" +
                " </td>\n" +
                " <td>\n" +
                " <b class=\"black\">\n" +
                " <a href=\"http://www.racingpost.com/horses/course_home.sd?crs_id=185\" onclick=\"return Html.popup(this, {width:695, height:800})\" title=\"Course (Click to view details): left-handed, sharp track (1m2f oval)\">Kln</a> 8Y/Sft </b>\n" +
                " 2y 6K </td>\n" +
                " <td>9-5</td>\n" +
                " <td>\n" +
                " <b class=\"black\">2</b>/8 <a href=\"http://www.racingpost.com/horses/result_home.sd?race_id=560635&amp;r_date=&amp;popup=yes\" onclick=\"scorecards.send(560635);return Html.popup(this, {width:695, height:800})\" title=\"raced in 4th, pushed along to chase winner inside final 2f, no impression final furlong\">(3?L Pussycat Lips 9-0)</a> 5/1 </td>\n" +
                " <td>\n" +
                " <a href=\"http://www.racingpost.com/horses/jockey_home.sd?jockey_id=11184\" onclick=\"scorecards.send(&quot;jockey_name&quot;);return Html.popup(this, {width:695, height:800})\" title=\"Full details about this JOCKEY\">Pat Smullen</a> </td>\n" +
                " <td class=\"num\">80</td>\n" +
                " <td class=\"num\"><span class=\"red bold\">*</span></td>\n" +
                " <td class=\"num last\"><span class=\"red bold\">*</span></td>\n" +
                " </tr>\n" +
                " <tr>\n" +
                " <td class=\"v\"><a href=\"#\" onclick=\"scorecards.sendSpecificDesc(&quot;ruk_video&quot;, &quot;176, 2012-07-06, 12:00&quot;);panels.mediaCentre.replayPopup($(this), 559951, 813959, '2012-07-06', 'RUK'); return false;\"><img src=\"http://ui.racingpost.com/release/v17/ico/video.17.0.gif\" alt=\"Video\" title=\"Video\"></a></td>\n" +
                " <td>\n" +
                " <a href=\"http://www.racingpost.com/horses/result_home.sd?race_id=559951&amp;r_date=2012-07-06&amp;popup=yes\" onclick=\"scorecards.send(559951);return Html.popup(this, {width:695, height:800})\" title=\"Irish Stallion Farms European Breeders Fund Median Auction Maiden\">06Jul12</a> &nbsp;\n" +
                " </td>\n" +
                " <td>\n" +
                " <b class=\"black\">\n" +
                " <a href=\"http://www.racingpost.com/horses/course_home.sd?crs_id=176\" onclick=\"return Html.popup(this, {width:695, height:800})\" title=\"Course (Click to view details): left-handed, sharp, undulating track (1m1f oval)\">Bel</a> 8Hy </b>\n" +
                " 2y 6K </td>\n" +
                " <td>9-5</td>\n" +
                " <td>\n" +
                " <b class=\"black\">3</b>/6 <a href=\"http://www.racingpost.com/horses/result_home.sd?race_id=559951&amp;r_date=&amp;popup=yes\" onclick=\"scorecards.send(559951);return Html.popup(this, {width:695, height:800})\" title=\"tracked leaders, 4th halfway, ridden to go 3rd over 1f out, no extra inside final furlong\">(4?L Lucked Out 9-5)</a> b 11/8F </td>\n" +
                " <td>\n" +
                " <a href=\"http://www.racingpost.com/horses/jockey_home.sd?jockey_id=11184\" onclick=\"scorecards.send(&quot;jockey_name&quot;);return Html.popup(this, {width:695, height:800})\" title=\"Full details about this JOCKEY\">Pat Smullen</a> </td>\n" +
                " <td class=\"num\">-</td>\n" +
                " <td class=\"num\"><span class=\"red bold\">*</span></td>\n" +
                " <td class=\"num last\"><span class=\"red bold\">*</span></td>\n" +
                " </tr>\n" +
                " <tr>\n" +
                " <td class=\"v\"><a href=\"#\" onclick=\"scorecards.sendSpecificDesc(&quot;ruk_video&quot;, &quot;193, 2012-06-15, 12:00&quot;);panels.mediaCentre.replayPopup($(this), 558440, 813959, '2012-06-15', 'RUK'); return false;\"><img src=\"http://ui.racingpost.com/release/v17/ico/video.17.0.gif\" alt=\"Video\" title=\"Video\"></a></td>\n" +
                " <td>\n" +
                " <a href=\"http://www.racingpost.com/horses/result_home.sd?race_id=558440&amp;r_date=2012-06-15&amp;popup=yes\" onclick=\"scorecards.send(558440);return Html.popup(this, {width:695, height:800})\" title=\"Irish Stallion Farms European Breeders Fund 2yo Median Auction Race\">15Jun12</a> &nbsp;\n" +
                " </td>\n" +
                " <td>\n" +
                " <b class=\"black\">\n" +
                " <a href=\"http://www.racingpost.com/horses/course_home.sd?crs_id=193\" onclick=\"return Html.popup(this, {width:695, height:800})\" title=\"Course (Click to view details): left-handed, undulating, galloping track (1m4f circuit)\">Nav</a> 6Sft/Hy </b>\n" +
                " 2y 10K </td>\n" +
                " <td>9-0</td>\n" +
                " <td>\n" +
                " <b class=\"black\">3</b>/6 <a href=\"http://www.racingpost.com/horses/result_home.sd?race_id=558440&amp;r_date=&amp;popup=yes\" onclick=\"scorecards.send(558440);return Html.popup(this, {width:695, height:800})\" title=\"chased leader in close 2nd, ridden in close 3rd 1f out, kept on final furlong, no extra close home\">(1L Versilia Gal 8-13)</a> 12/1 </td>\n" +
                " <td>\n" +
                " <a href=\"http://www.racingpost.com/horses/jockey_home.sd?jockey_id=11184\" onclick=\"scorecards.send(&quot;jockey_name&quot;);return Html.popup(this, {width:695, height:800})\" title=\"Full details about this JOCKEY\">Pat Smullen</a> </td>\n" +
                " <td class=\"num\">-</td>\n" +
                " <td class=\"num\"><span class=\"red bold\">*</span></td>\n" +
                " <td class=\"num last\"><span class=\"red bold\">*</span></td>\n" +
                " </tr>\n" +
                " <tr>\n" +
                " <td class=\"v\"><a href=\"#\" onclick=\"scorecards.sendSpecificDesc(&quot;ruk_video&quot;, &quot;178, 2012-06-10, 12:00&quot;);panels.mediaCentre.replayPopup($(this), 557970, 813959, '2012-06-10', 'RUK'); return false;\"><img src=\"http://ui.racingpost.com/release/v17/ico/video.17.0.gif\" alt=\"Video\" title=\"Video\"></a></td>\n" +
                " <td>\n" +
                " <a href=\"http://www.racingpost.com/horses/result_home.sd?race_id=557970&amp;r_date=2012-06-10&amp;popup=yes\" onclick=\"scorecards.send(557970);return Html.popup(this, {width:695, height:800})\" title=\"Irish Stallion Farms European Breeders Fund 2yo Maiden\">10Jun12</a> &nbsp;\n" +
                " </td>\n" +
                " <td>\n" +
                " <b class=\"black\">\n" +
                " <a href=\"http://www.racingpost.com/horses/course_home.sd?crs_id=178\" onclick=\"return Html.popup(this, {width:695, height:800})\" title=\"Course (Click to view details): right-handed, galloping, testing, horseshoe (2m) + chute (races up to 1m)\">Cur</a> 6Sft/Hy </b>\n" +
                " 2y 9K </td>\n" +
                " <td>9-5</td>\n" +
                " <td>\n" +
                " <b class=\"black\">7</b>/8 <a href=\"http://www.racingpost.com/horses/result_home.sd?race_id=557970&amp;r_date=&amp;popup=yes\" onclick=\"scorecards.send(557970);return Html.popup(this, {width:695, height:800})\" title=\"dwelt, towards rear, no impression and kept on same pace under pressure from 2f out\">(8?L Gale Force Ten 9-5)</a> 14/1 </td>\n" +
                " <td>\n" +
                " <a href=\"http://www.racingpost.com/horses/jockey_home.sd?jockey_id=11184\" onclick=\"scorecards.send(&quot;jockey_name&quot;);return Html.popup(this, {width:695, height:800})\" title=\"Full details about this JOCKEY\">Pat Smullen</a> </td>\n" +
                " <td class=\"num\">-</td>\n" +
                " <td class=\"num\"><span class=\"red bold\">*</span></td>\n" +
                " <td class=\"num last\"><span class=\"red bold\">*</span></td>\n" +
                " </tr>\n" +
                " </tbody></table>\n" +
                " <span id=\"barrier_RPR-TS_In_Form7228227566\" class=\"bar prpTsInfo\"><span id=\"ruli_33\"><span class=\"red bold\">*</span> Historical RP Ratings and Topspeed Ratings are part of Racing Post Members' Club <a href=\"#\" class=\"blue\" onclick=\"javascript:callLogin('special_offer');\"> Log in to view</a></span></span></div>\n" +
                "<div id=\"sc_raceHorseNotes_813959\" class=\"notes\" style=\"display: none; \"></div>\n" +
                "\n" +
                " </td>\n" +
                " </tr>\n" +
                " <tr>\n" +
                " <td colspan=\"7\"><tt><i></i></tt></td>\n" +
                " </tr>\n" +
                " </tbody><tbody id=\"sc_61564719\">\n" +
                " <tr class=\"cr\">\n" +
                " <td class=\"t\">\n" +
                " <strong>2</strong><sup>7</sup> <em>351</em>\n" +
                " </td>\n" +
                " <td class=\"s\">\n" +
                " <a href=\"http://www.racingpost.com/horses/owner_home.sd?owner_id=143761\" onclick=\"scorecards.send(&quot;owner_name&quot;);return Html.popup(this, {width:695, height:800})\" title=\"Full details about this OWNER\"><img src=\"http://images.racingpost.com/png_silks/c/1/6/143761c.png\" class=\"iepng\" alt=\"Owner details\" title=\"Full details about this OWNER\" width=\"40\" height=\"29\"></a> </td>\n" +
                " \n" +
                " <td class=\"h\">\n" +
                " <div class=\"nm\">\n" +
                " <a href=\"http://www.racingpost.com/horses/horse_home.sd?race_id=565793&amp;r_date=2012-10-16&amp;horse_id=800437\" onclick=\"scorecards.send(&quot;horse_name&quot;);return Html.popup(this, {width:695, height:800})\" title=\"Full details about this HORSE\"><b>KINGDOM</b></a> <img src=\"http://ui.racingpost.com/ico/distance-cd.gif\" class=\"cdbf\" alt=\"\"> <span>\n" +
                " p </span>\n" +
                " \n" +
                " <a href=\"#\" id=\"sc_pencil_800437\" title=\"Show/Hide My Notes for this runner\"></a> </div>\n" +
                "\n" +
                " <div class=\"oddsBar oddsBarFavorite\">\n" +
                " <div><div style=\"width: 57%\"></div></div>\n" +
                " <span>57%</span>\n" +
                " </div>\n" +
                " </td>\n" +
                " <td class=\"two c\">\n" +
                " <div class=\"tips\">5</div>\n" +
                " <div class=\"rpr\">89</div>\n" +
                " <div class=\"ts\">81 </div>\n" +
                " </td>\n" +
                " <td class=\"two jt\">\n" +
                " <div>\n" +
                " <a href=\"http://www.racingpost.com/horses/trainer_home.sd?trainer_id=7978\" onclick=\"scorecards.send(&quot;trainer_name&quot;);return Html.popup(this, {width:695, height:800})\" title=\"Full details about this TRAINER\">A P O'Brien</a><sup><span title=\"the percentage of the stable's runners that have Run To Form in the last 14 days, based on RPR\">66</span></sup> </div>\n" +
                " <div>\n" +
                " <a href=\"http://www.racingpost.com/horses/jockey_home.sd?jockey_id=88530\" onclick=\"scorecards.send(&quot;jockey_name&quot;);return Html.popup(this, {width:695, height:800})\" title=\"Full details about this JOCKEY\">J P O'Brien</a> </div>\n" +
                " </td>\n" +
                " <td class=\"two awo\">\n" +
                " <div>\n" +
                " 2 &nbsp;\n" +
                " 9-5 </div>\n" +
                " <div>\n" +
                " - </div>\n" +
                " </td>\n" +
                " <td class=\"bk\" id=\"sc_61564719_bk\"><strong class=\"noBetting\">No betting</strong></td>\n" +
                " </tr>\n" +
                " <tr>\n" +
                " <td class=\"cardItemInfo\" colspan=\"7\">\n" +
                " <p class=\"diomed\">\n" +
                " Future plans more ambitious. Encouraging recent effort, build on that and show these whose boss </p>\n" +
                " <div class=\"forms\">\n" +
                " <table class=\"grid smallSpaceGrid\">\n" +
                " <tbody><tr class=\"noSpace\">\n" +
                " <th class=\"v\">&nbsp;</th>\n" +
                " <th class=\"date\">DATE</th>\n" +
                " <th class=\"raceCond\">RACE CONDITIONS</th>\n" +
                " <th class=\"wgt\">WGT</th>\n" +
                " <th class=\"raceOut\">RACE OUTCOME</th>\n" +
                " <th class=\"jock\">JOCKEY</th>\n" +
                " <th class=\"num\">OR</th>\n" +
                " <th class=\"num\">TS</th>\n" +
                " <th class=\"num last\">RPR</th>\n" +
                " </tr>\n" +
                " <tr>\n" +
                " <td class=\"v\"><a href=\"#\" onclick=\"scorecards.sendSpecificDesc(&quot;ruk_video&quot;, &quot;178, 2012-10-16, 12:00&quot;);panels.mediaCentre.replayPopup($(this), 565793, 800437, '2012-10-16', 'RUK'); return false;\"><img src=\"http://ui.racingpost.com/release/v17/ico/video.17.0.gif\" alt=\"Video\" title=\"Video\"></a></td>\n" +
                " <td>\n" +
                " <a href=\"http://www.racingpost.com/horses/result_home.sd?race_id=565793&amp;r_date=2012-10-16&amp;popup=yes\" onclick=\"scorecards.send(565793);return Html.popup(this, {width:695, height:800})\" title=\"Curragh Dining &amp; Hospitality Options 2013 Maiden\">16Oct12</a> &nbsp;\n" +
                " </td>\n" +
                " <td>\n" +
                " <b class=\"black\">\n" +
                " <a href=\"http://www.racingpost.com/horses/course_home.sd?crs_id=178\" onclick=\"return Html.popup(this, {width:695, height:800})\" title=\"Course (Click to view details): right-handed, galloping, testing, horseshoe (2m) + chute (races up to 1m)\">Cur</a> 7Hy </b>\n" +
                " 2y 5K </td>\n" +
                " <td>9-5</td>\n" +
                " <td>\n" +
                " <b class=\"black\">1</b>/6 <a href=\"http://www.racingpost.com/horses/result_home.sd?race_id=565793&amp;r_date=&amp;popup=yes\" onclick=\"scorecards.send(565793);return Html.popup(this, {width:695, height:800})\" title=\"soon led on nearside, narrow advantage 3f out, ridden entering final furlong and kept on under pressure towards finish, just\">(nk Pay Day Kitten 9-0)</a> p 4/11F </td>\n" +
                " <td>\n" +
                " <a href=\"http://www.racingpost.com/horses/jockey_home.sd?jockey_id=88530\" onclick=\"scorecards.send(&quot;jockey_name&quot;);return Html.popup(this, {width:695, height:800})\" title=\"Full details about this JOCKEY\">J P O'Brien</a> </td>\n" +
                " <td class=\"num\">-</td>\n" +
                " <td class=\"num\"><span class=\"red bold\">*</span></td>\n" +
                " <td class=\"num last\"><span class=\"red bold\">*</span></td>\n" +
                " </tr>\n" +
                " <tr>\n" +
                " <td class=\"v\"><a href=\"#\" onclick=\"scorecards.sendSpecificDesc(&quot;ruk_video&quot;, &quot;184, 2012-09-23, 12:00&quot;);panels.mediaCentre.replayPopup($(this), 564284, 800437, '2012-09-23', 'RUK'); return false;\"><img src=\"http://ui.racingpost.com/release/v17/ico/video.17.0.gif\" alt=\"Video\" title=\"Video\"></a></td>\n" +
                " <td>\n" +
                " <a href=\"http://www.racingpost.com/horses/result_home.sd?race_id=564284&amp;r_date=2012-09-23&amp;popup=yes\" onclick=\"scorecards.send(564284);return Html.popup(this, {width:695, height:800})\" title=\"Powerstown Stud European Breeders Fund Maiden\">23Sep12</a> &nbsp;\n" +
                " </td>\n" +
                " <td>\n" +
                " <b class=\"black\">\n" +
                " <a href=\"http://www.racingpost.com/horses/course_home.sd?crs_id=184\" onclick=\"return Html.popup(this, {width:695, height:800})\" title=\"Course (Click to view details): right-handed, undulating track (1m4f circuit)\">Gow</a> 8Gd </b>\n" +
                " 2y 7K </td>\n" +
                " <td>9-5</td>\n" +
                " <td>\n" +
                " <b class=\"black\">5</b>/16 <a href=\"http://www.racingpost.com/horses/result_home.sd?race_id=564284&amp;r_date=&amp;popup=yes\" onclick=\"scorecards.send(564284);return Html.popup(this, {width:695, height:800})\" title=\"tacked over to chase leaders early, 2nd 4f out, pushed along approaching straight and soon no extra\">(10?L Trading Leather 9-5)</a> 5/2 </td>\n" +
                " <td>\n" +
                " <a href=\"http://www.racingpost.com/horses/jockey_home.sd?jockey_id=88530\" onclick=\"scorecards.send(&quot;jockey_name&quot;);return Html.popup(this, {width:695, height:800})\" title=\"Full details about this JOCKEY\">J P O'Brien</a> </td>\n" +
                " <td class=\"num\">-</td>\n" +
                " <td class=\"num\"><span class=\"red bold\">*</span></td>\n" +
                " <td class=\"num last\"><span class=\"red bold\">*</span></td>\n" +
                " </tr>\n" +
                " <tr>\n" +
                " <td class=\"v\"><a href=\"#\" onclick=\"scorecards.sendSpecificDesc(&quot;ruk_video&quot;, &quot;183, 2012-09-10, 12:00&quot;);panels.mediaCentre.replayPopup($(this), 563707, 800437, '2012-09-10', 'RUK'); return false;\"><img src=\"http://ui.racingpost.com/release/v17/ico/video.17.0.gif\" alt=\"Video\" title=\"Video\"></a></td>\n" +
                " <td>\n" +
                " <a href=\"http://www.racingpost.com/horses/result_home.sd?race_id=563707&amp;r_date=2012-09-10&amp;popup=yes\" onclick=\"scorecards.send(563707);return Html.popup(this, {width:695, height:800})\" title=\"Donnelly's Of Barna European Breeders Fund Maiden\">10Sep12</a> &nbsp;\n" +
                " </td>\n" +
                " <td>\n" +
                " <b class=\"black\">\n" +
                " <a href=\"http://www.racingpost.com/horses/course_home.sd?crs_id=183\" onclick=\"return Html.popup(this, {width:695, height:800})\" title=\"Course (Click to view details): right-handed, undulating, testing track (1m2f rectangle)\">Gal</a> 8Hy </b>\n" +
                " 2y 10K </td>\n" +
                " <td>9-5</td>\n" +
                " <td>\n" +
                " <b class=\"black\">3</b>/8 <a href=\"http://www.racingpost.com/horses/result_home.sd?race_id=563707&amp;r_date=&amp;popup=yes\" onclick=\"scorecards.send(563707);return Html.popup(this, {width:695, height:800})\" title=\"dwelt and held up in rear, headway into 6th 2f out, pushed along to close on inner and stayed on well inside final furlong to almost take 2nd final strides, nearest finish\">(2?L Eye Of The Storm 9-5)</a> 11/2 </td>\n" +
                " <td>\n" +
                " <a href=\"http://www.racingpost.com/horses/jockey_home.sd?jockey_id=7605\" onclick=\"scorecards.send(&quot;jockey_name&quot;);return Html.popup(this, {width:695, height:800})\" title=\"Full details about this JOCKEY\">Seamie Heffernan</a> </td>\n" +
                " <td class=\"num\">-</td>\n" +
                " <td class=\"num\"><span class=\"red bold\">*</span></td>\n" +
                " <td class=\"num last\"><span class=\"red bold\">*</span></td>\n" +
                " </tr>\n" +
                " </tbody></table>\n" +
                " <span id=\"barrier_RPR-TS_In_Form1599740182\" class=\"bar prpTsInfo\"><span id=\"ruli_33\"><span class=\"red bold\">*</span> Historical RP Ratings and Topspeed Ratings are part of Racing Post Members' Club <a href=\"#\" class=\"blue\" onclick=\"javascript:callLogin('special_offer');\"> Log in to view</a></span></span></div>\n" +
                "<div id=\"sc_raceHorseNotes_800437\" class=\"notes\" style=\"display: none; \"></div>\n" +
                "\n" +
                " </td>\n" +
                " </tr>\n" +
                " <tr>\n" +
                " <td colspan=\"7\"><tt><i></i></tt></td>\n" +
                " </tr>\n" +
                " </tbody><tbody id=\"sc_61564721\">\n" +
                " <tr class=\"cr\">\n" +
                " <td class=\"t\">\n" +
                " <strong>3</strong><sup>4</sup> <em><b>6</b>4</em>\n" +
                " </td>\n" +
                " <td class=\"s\">\n" +
                " <a href=\"http://www.racingpost.com/horses/owner_home.sd?owner_id=90224\" onclick=\"scorecards.send(&quot;owner_name&quot;);return Html.popup(this, {width:695, height:800})\" title=\"Full details about this OWNER\"><img src=\"http://images.racingpost.com/png_silks/4/2/2/90224.png\" class=\"iepng\" alt=\"Owner details\" title=\"Full details about this OWNER\" width=\"40\" height=\"29\"></a> </td>\n" +
                " \n" +
                " <td class=\"h\">\n" +
                " <div class=\"nm\">\n" +
                " <a href=\"http://www.racingpost.com/horses/horse_home.sd?race_id=565793&amp;r_date=2012-10-16&amp;horse_id=816284\" onclick=\"scorecards.send(&quot;horse_name&quot;);return Html.popup(this, {width:695, height:800})\" title=\"Full details about this HORSE\"><b>LUCKY KITTEN</b></a> \n" +
                " <a href=\"#\" id=\"sc_pencil_816284\" title=\"Show/Hide My Notes for this runner\"></a> </div>\n" +
                "\n" +
                " <div class=\"oddsBar\">\n" +
                " <div><div style=\"width: 8%\"></div></div>\n" +
                " <span>8%</span>\n" +
                " </div>\n" +
                " </td>\n" +
                " <td class=\"two c\">\n" +
                " <div class=\"tips\">0</div>\n" +
                " <div class=\"rpr\">73</div>\n" +
                " <div class=\"ts\">-</div>\n" +
                " </td>\n" +
                " <td class=\"two jt\">\n" +
                " <div>\n" +
                " <a href=\"http://www.racingpost.com/horses/trainer_home.sd?trainer_id=1010\" onclick=\"scorecards.send(&quot;trainer_name&quot;);return Html.popup(this, {width:695, height:800})\" title=\"Full details about this TRAINER\">D K Weld</a><sup><span title=\"the percentage of the stable's runners that have Run To Form in the last 14 days, based on RPR\">35</span></sup> </div>\n" +
                " <div>\n" +
                " <a href=\"http://www.racingpost.com/horses/jockey_home.sd?jockey_id=89571\" onclick=\"scorecards.send(&quot;jockey_name&quot;);return Html.popup(this, {width:695, height:800})\" title=\"Full details about this JOCKEY\">Leigh Roche</a><sup>3</sup> </div>\n" +
                " </td>\n" +
                " <td class=\"two awo\">\n" +
                " <div>\n" +
                " 2 &nbsp;\n" +
                " 9-5 </div>\n" +
                " <div>\n" +
                " - </div>\n" +
                " </td>\n" +
                " <td class=\"bk\" id=\"sc_61564721_bk\"><strong class=\"noBetting\">No betting</strong></td>\n" +
                " </tr>\n" +
                " <tr>\n" +
                " <td class=\"cardItemInfo\" colspan=\"7\">\n" +
                " <p class=\"diomed\">\n" +
                " Makes extremely limited appeal, gain no comfort from the distance of race either </p>\n" +
                " <div class=\"forms\">\n" +
                " <table class=\"grid smallSpaceGrid\">\n" +
                " <tbody><tr class=\"noSpace\">\n" +
                " <th class=\"v\">&nbsp;</th>\n" +
                " <th class=\"date\">DATE</th>\n" +
                " <th class=\"raceCond\">RACE CONDITIONS</th>\n" +
                " <th class=\"wgt\">WGT</th>\n" +
                " <th class=\"raceOut\">RACE OUTCOME</th>\n" +
                " <th class=\"jock\">JOCKEY</th>\n" +
                " <th class=\"num\">OR</th>\n" +
                " <th class=\"num\">TS</th>\n" +
                " <th class=\"num last\">RPR</th>\n" +
                " </tr>\n" +
                " <tr>\n" +
                " <td class=\"v\"><a href=\"#\" onclick=\"scorecards.sendSpecificDesc(&quot;ruk_video&quot;, &quot;178, 2012-10-16, 12:00&quot;);panels.mediaCentre.replayPopup($(this), 565793, 816284, '2012-10-16', 'RUK'); return false;\"><img src=\"http://ui.racingpost.com/release/v17/ico/video.17.0.gif\" alt=\"Video\" title=\"Video\"></a></td>\n" +
                " <td>\n" +
                " <a href=\"http://www.racingpost.com/horses/result_home.sd?race_id=565793&amp;r_date=2012-10-16&amp;popup=yes\" onclick=\"scorecards.send(565793);return Html.popup(this, {width:695, height:800})\" title=\"Curragh Dining &amp; Hospitality Options 2013 Maiden\">16Oct12</a> &nbsp;\n" +
                " </td>\n" +
                " <td>\n" +
                " <b class=\"black\">\n" +
                " <a href=\"http://www.racingpost.com/horses/course_home.sd?crs_id=178\" onclick=\"return Html.popup(this, {width:695, height:800})\" title=\"Course (Click to view details): right-handed, galloping, testing, horseshoe (2m) + chute (races up to 1m)\">Cur</a> 7Hy </b>\n" +
                " 2y 5K </td>\n" +
                " <td>9-2</td>\n" +
                " <td>\n" +
                " <b class=\"black\">4</b>/6 <a href=\"http://www.racingpost.com/horses/result_home.sd?race_id=565793&amp;r_date=&amp;popup=yes\" onclick=\"scorecards.send(565793);return Html.popup(this, {width:695, height:800})\" title=\"held up, niggled along in 5th 3f out, ridden and no impression on principals from 2f out, kept on final furlong\">(11?L Kingdom 9-5)</a> 12/1 </td>\n" +
                " <td>\n" +
                " <a href=\"http://www.racingpost.com/horses/jockey_home.sd?jockey_id=89571\" onclick=\"scorecards.send(&quot;jockey_name&quot;);return Html.popup(this, {width:695, height:800})\" title=\"Full details about this JOCKEY\">Leigh Roche</a> </td>\n" +
                " <td class=\"num\">-</td>\n" +
                " <td class=\"num\"><span class=\"red bold\">*</span></td>\n" +
                " <td class=\"num last\"><span class=\"red bold\">*</span></td>\n" +
                " </tr>\n" +
                " <tr>\n" +
                " <td class=\"v\"><a href=\"#\" onclick=\"scorecards.sendSpecificDesc(&quot;ruk_video&quot;, &quot;1138, 2012-09-02, 12:00&quot;);panels.mediaCentre.replayPopup($(this), 563131, 816284, '2012-09-02', 'RUK'); return false;\"><img src=\"http://ui.racingpost.com/release/v17/ico/video.17.0.gif\" alt=\"Video\" title=\"Video\"></a></td>\n" +
                " <td>\n" +
                " <a href=\"http://www.racingpost.com/horses/result_home.sd?race_id=563131&amp;r_date=2012-09-02&amp;popup=yes\" onclick=\"scorecards.send(563131);return Html.popup(this, {width:695, height:800})\" title=\"www.sesif.org Race\">02Sep12</a> &nbsp;\n" +
                " </td>\n" +
                " <td>\n" +
                " <b class=\"black\">\n" +
                " <a href=\"http://www.racingpost.com/horses/course_home.sd?crs_id=1138\" onclick=\"return Html.popup(this, {width:695, height:800})\" title=\"Course (Click to view details): AW Polytrack: left-handed (1m2f oval).\">Dun</a> 7St </b>\n" +
                " 2y 8K </td>\n" +
                " <td>9-3</td>\n" +
                " <td>\n" +
                " <b class=\"black\">6</b>/6 <a href=\"http://www.racingpost.com/horses/result_home.sd?race_id=563131&amp;r_date=&amp;popup=yes\" onclick=\"scorecards.send(563131);return Html.popup(this, {width:695, height:800})\" title=\"raced in 5th, pushed along over 2f out, soon no impression\">(10L Sir Walter Scott 9-3)</a> 9/1 </td>\n" +
                " <td>\n" +
                " <a href=\"http://www.racingpost.com/horses/jockey_home.sd?jockey_id=11184\" onclick=\"scorecards.send(&quot;jockey_name&quot;);return Html.popup(this, {width:695, height:800})\" title=\"Full details about this JOCKEY\">Pat Smullen</a> </td>\n" +
                " <td class=\"num\">-</td>\n" +
                " <td class=\"num\"><span class=\"red bold\">*</span></td>\n" +
                " <td class=\"num last\"><span class=\"red bold\">*</span></td>\n" +
                " </tr>\n" +
                " </tbody></table>\n" +
                " <span id=\"barrier_RPR-TS_In_Form31009068811\" class=\"bar prpTsInfo\"><span id=\"ruli_33\"><span class=\"red bold\">*</span> Historical RP Ratings and Topspeed Ratings are part of Racing Post Members' Club <a href=\"#\" class=\"blue\" onclick=\"javascript:callLogin('special_offer');\"> Log in to view</a></span></span></div>\n" +
                "<div id=\"sc_raceHorseNotes_816284\" class=\"notes\" style=\"display: none; \"></div>\n" +
                "\n" +
                " </td>\n" +
                " </tr>\n" +
                " <tr>\n" +
                " <td colspan=\"7\"><tt><i></i></tt></td>\n" +
                " </tr>\n" +
                " </tbody><tbody id=\"sc_61564724\">\n" +
                " <tr class=\"cr\">\n" +
                " <td class=\"t\">\n" +
                " <strong>4</strong><sup>6</sup> <em>076</em>\n" +
                " </td>\n" +
                " <td class=\"s\">\n" +
                " <a href=\"http://www.racingpost.com/horses/owner_home.sd?owner_id=50649\" onclick=\"scorecards.send(&quot;owner_name&quot;);return Html.popup(this, {width:695, height:800})\" title=\"Full details about this OWNER\"><img src=\"http://images.racingpost.com/png_silks/9/4/6/50649.png\" class=\"iepng\" alt=\"Owner details\" title=\"Full details about this OWNER\" width=\"40\" height=\"29\"></a> </td>\n" +
                " \n" +
                " <td class=\"h\">\n" +
                " <div class=\"nm\">\n" +
                " <a href=\"http://www.racingpost.com/horses/horse_home.sd?race_id=565793&amp;r_date=2012-10-16&amp;horse_id=820782\" onclick=\"scorecards.send(&quot;horse_name&quot;);return Html.popup(this, {width:695, height:800})\" title=\"Full details about this HORSE\"><b>ROCK N ROVER</b></a> \n" +
                " <a href=\"#\" id=\"sc_pencil_820782\" title=\"Show/Hide My Notes for this runner\"></a> </div>\n" +
                "\n" +
                " <div class=\"oddsBar\">\n" +
                " <div><div style=\"width: 5%\"></div></div>\n" +
                " <span>5%</span>\n" +
                " </div>\n" +
                " </td>\n" +
                " <td class=\"two c\">\n" +
                " <div class=\"tips\">0</div>\n" +
                " <div class=\"rpr\">53</div>\n" +
                " <div class=\"ts\">39 </div>\n" +
                " </td>\n" +
                " <td class=\"two jt\">\n" +
                " <div>\n" +
                " <a href=\"http://www.racingpost.com/horses/trainer_home.sd?trainer_id=4446\" onclick=\"scorecards.send(&quot;trainer_name&quot;);return Html.popup(this, {width:695, height:800})\" title=\"Full details about this TRAINER\">Noel Meade</a><sup><span title=\"the percentage of the stable's runners that have Run To Form in the last 14 days, based on RPR\">33</span></sup> </div>\n" +
                " <div>\n" +
                " <a href=\"http://www.racingpost.com/horses/jockey_home.sd?jockey_id=86592\" onclick=\"scorecards.send(&quot;jockey_name&quot;);return Html.popup(this, {width:695, height:800})\" title=\"Full details about this JOCKEY\">Emmet McNamara</a> </div>\n" +
                " </td>\n" +
                " <td class=\"two awo\">\n" +
                " <div>\n" +
                " 2 &nbsp;\n" +
                " 9-5 </div>\n" +
                " <div>\n" +
                " - </div>\n" +
                " </td>\n" +
                " <td class=\"bk\" id=\"sc_61564724_bk\"><strong class=\"noBetting\">No betting</strong></td>\n" +
                " </tr>\n" +
                " <tr>\n" +
                " <td class=\"cardItemInfo\" colspan=\"7\">\n" +
                " <p class=\"diomed\">\n" +
                " Those who follow stable's in form will look no further, decent chance </p>\n" +
                " <div class=\"forms\">\n" +
                " <table class=\"grid smallSpaceGrid\">\n" +
                " <tbody><tr class=\"noSpace\">\n" +
                " <th class=\"v\">&nbsp;</th>\n" +
                " <th class=\"date\">DATE</th>\n" +
                " <th class=\"raceCond\">RACE CONDITIONS</th>\n" +
                " <th class=\"wgt\">WGT</th>\n" +
                " <th class=\"raceOut\">RACE OUTCOME</th>\n" +
                " <th class=\"jock\">JOCKEY</th>\n" +
                " <th class=\"num\">OR</th>\n" +
                " <th class=\"num\">TS</th>\n" +
                " <th class=\"num last\">RPR</th>\n" +
                " </tr>\n" +
                " <tr>\n" +
                " <td class=\"v\"><a href=\"#\" onclick=\"scorecards.sendSpecificDesc(&quot;ruk_video&quot;, &quot;178, 2012-10-16, 12:00&quot;);panels.mediaCentre.replayPopup($(this), 565793, 820782, '2012-10-16', 'RUK'); return false;\"><img src=\"http://ui.racingpost.com/release/v17/ico/video.17.0.gif\" alt=\"Video\" title=\"Video\"></a></td>\n" +
                " <td>\n" +
                " <a href=\"http://www.racingpost.com/horses/result_home.sd?race_id=565793&amp;r_date=2012-10-16&amp;popup=yes\" onclick=\"scorecards.send(565793);return Html.popup(this, {width:695, height:800})\" title=\"Curragh Dining &amp; Hospitality Options 2013 Maiden\">16Oct12</a> &nbsp;\n" +
                " </td>\n" +
                " <td>\n" +
                " <b class=\"black\">\n" +
                " <a href=\"http://www.racingpost.com/horses/course_home.sd?crs_id=178\" onclick=\"return Html.popup(this, {width:695, height:800})\" title=\"Course (Click to view details): right-handed, galloping, testing, horseshoe (2m) + chute (races up to 1m)\">Cur</a> 7Hy </b>\n" +
                " 2y 5K </td>\n" +
                " <td>9-5</td>\n" +
                " <td>\n" +
                " <b class=\"black\">6</b>/6 <a href=\"http://www.racingpost.com/horses/result_home.sd?race_id=565793&amp;r_date=&amp;popup=yes\" onclick=\"scorecards.send(565793);return Html.popup(this, {width:695, height:800})\" title=\"hooded to load, waited with in rear, short of room and stumbled after 1f, ridden over 2f out and weakened\">(19?L Kingdom 9-5)</a> 20/1 </td>\n" +
                " <td>\n" +
                " <a href=\"http://www.racingpost.com/horses/jockey_home.sd?jockey_id=86592\" onclick=\"scorecards.send(&quot;jockey_name&quot;);return Html.popup(this, {width:695, height:800})\" title=\"Full details about this JOCKEY\">Emmet McNamara</a> </td>\n" +
                " <td class=\"num\">-</td>\n" +
                " <td class=\"num\"><span class=\"red bold\">*</span></td>\n" +
                " <td class=\"num last\"><span class=\"red bold\">*</span></td>\n" +
                " </tr>\n" +
                " <tr>\n" +
                " <td class=\"v\"><a href=\"#\" onclick=\"scorecards.sendSpecificDesc(&quot;ruk_video&quot;, &quot;193, 2012-10-10, 12:00&quot;);panels.mediaCentre.replayPopup($(this), 565364, 820782, '2012-10-10', 'RUK'); return false;\"><img src=\"http://ui.racingpost.com/release/v17/ico/video.17.0.gif\" alt=\"Video\" title=\"Video\"></a></td>\n" +
                " <td>\n" +
                " <a href=\"http://www.racingpost.com/horses/result_home.sd?race_id=565364&amp;r_date=2012-10-10&amp;popup=yes\" onclick=\"scorecards.send(565364);return Html.popup(this, {width:695, height:800})\" title=\"Irish Stallion Farms European Breeders Fund (C &amp; G) Maiden\">10Oct12</a> &nbsp;\n" +
                " </td>\n" +
                " <td>\n" +
                " <b class=\"black\">\n" +
                " <a href=\"http://www.racingpost.com/horses/course_home.sd?crs_id=193\" onclick=\"return Html.popup(this, {width:695, height:800})\" title=\"Course (Click to view details): left-handed, undulating, galloping track (1m4f circuit)\">Nav</a> 8Sft </b>\n" +
                " 2y 8K </td>\n" +
                " <td>9-5</td>\n" +
                " <td>\n" +
                " <b class=\"black\">7</b>/8 <a href=\"http://www.racingpost.com/horses/result_home.sd?race_id=565364&amp;r_date=&amp;popup=yes\" onclick=\"scorecards.send(565364);return Html.popup(this, {width:695, height:800})\" title=\"went right start, held up in touch, 7th halfway, effort over 3f out and no impression, kept on final furlong\">(19L Kingsbarns 9-5)</a> 9/1 </td>\n" +
                " <td>\n" +
                " <a href=\"http://www.racingpost.com/horses/jockey_home.sd?jockey_id=14262\" onclick=\"scorecards.send(&quot;jockey_name&quot;);return Html.popup(this, {width:695, height:800})\" title=\"Full details about this JOCKEY\">C O'Donoghue</a> </td>\n" +
                " <td class=\"num\">-</td>\n" +
                " <td class=\"num\"><span class=\"red bold\">*</span></td>\n" +
                " <td class=\"num last\"><span class=\"red bold\">*</span></td>\n" +
                " </tr>\n" +
                " <tr>\n" +
                " <td class=\"v\"><a href=\"#\" onclick=\"scorecards.sendSpecificDesc(&quot;ruk_video&quot;, &quot;182, 2012-09-24, 12:00&quot;);panels.mediaCentre.replayPopup($(this), 564492, 820782, '2012-09-24', 'RUK'); return false;\"><img src=\"http://ui.racingpost.com/release/v17/ico/video.17.0.gif\" alt=\"Video\" title=\"Video\"></a></td>\n" +
                " <td>\n" +
                " <a href=\"http://www.racingpost.com/horses/result_home.sd?race_id=564492&amp;r_date=2012-09-24&amp;popup=yes\" onclick=\"scorecards.send(564492);return Html.popup(this, {width:695, height:800})\" title=\"Tattersalls Ireland Super Auction Sale Stakes\">24Sep12</a> &nbsp;\n" +
                " </td>\n" +
                " <td>\n" +
                " <b class=\"black\">\n" +
                " <a href=\"http://www.racingpost.com/horses/course_home.sd?crs_id=182\" onclick=\"return Html.popup(this, {width:695, height:800})\" title=\"Course (Click to view details): right-handed, galloping, testing track (1m6f circuit)\">Fai</a> 7Hy </b>\n" +
                " 2y 51K </td>\n" +
                " <td>8-11</td>\n" +
                " <td>\n" +
                " <b class=\"black\">10</b>/13 <a href=\"http://www.racingpost.com/horses/result_home.sd?race_id=564492&amp;r_date=&amp;popup=yes\" onclick=\"scorecards.send(564492);return Html.popup(this, {width:695, height:800})\" title=\"dwelt and raced in rear, some late headway final furlong, never a factor\">(22L Three Sea Captains 9-6)</a> 20/1 </td>\n" +
                " <td>\n" +
                " <a href=\"http://www.racingpost.com/horses/jockey_home.sd?jockey_id=14262\" onclick=\"scorecards.send(&quot;jockey_name&quot;);return Html.popup(this, {width:695, height:800})\" title=\"Full details about this JOCKEY\">C O'Donoghue</a> </td>\n" +
                " <td class=\"num\">-</td>\n" +
                " <td class=\"num\"><span class=\"red bold\">*</span></td>\n" +
                " <td class=\"num last\"><span class=\"red bold\">*</span></td>\n" +
                " </tr>\n" +
                " </tbody></table>\n" +
                " <span id=\"barrier_RPR-TS_In_Form51316983895\" class=\"bar prpTsInfo\"><span id=\"ruli_33\"><span class=\"red bold\">*</span> Historical RP Ratings and Topspeed Ratings are part of Racing Post Members' Club <a href=\"#\" class=\"blue\" onclick=\"javascript:callLogin('special_offer');\"> Log in to view</a></span></span></div>\n" +
                "<div id=\"sc_raceHorseNotes_820782\" class=\"notes\" style=\"display: none; \"></div>\n" +
                "\n" +
                " </td>\n" +
                " </tr>\n" +
                " <tr>\n" +
                " <td colspan=\"7\"><tt><i></i></tt></td>\n" +
                " </tr>\n" +
                " </tbody><tbody id=\"sc_61564723\">\n" +
                " <tr class=\"cr\">\n" +
                " <td class=\"t\">\n" +
                " <strong>5</strong><sup>1</sup> <em><b>9</b>3</em>\n" +
                " </td>\n" +
                " <td class=\"s\">\n" +
                " <a href=\"http://www.racingpost.com/horses/owner_home.sd?owner_id=173079\" onclick=\"scorecards.send(&quot;owner_name&quot;);return Html.popup(this, {width:695, height:800})\" title=\"Full details about this OWNER\"><img src=\"http://images.racingpost.com/png_silks/9/7/0/173079.png\" class=\"iepng\" alt=\"Owner details\" title=\"Full details about this OWNER\" width=\"40\" height=\"29\"></a> </td>\n" +
                " \n" +
                " <td class=\"h\">\n" +
                " <div class=\"nm\">\n" +
                " <a href=\"http://www.racingpost.com/horses/horse_home.sd?race_id=565793&amp;r_date=2012-10-16&amp;horse_id=818910\" onclick=\"scorecards.send(&quot;horse_name&quot;);return Html.popup(this, {width:695, height:800})\" title=\"Full details about this HORSE\"><b>SOPHISTICATED HEIR</b></a> \n" +
                " <a href=\"#\" id=\"sc_pencil_818910\" title=\"Show/Hide My Notes for this runner\"></a> </div>\n" +
                "\n" +
                " <div class=\"oddsBar\">\n" +
                " <div><div style=\"width: 18%\"></div></div>\n" +
                " <span>18%</span>\n" +
                " </div>\n" +
                " </td>\n" +
                " <td class=\"two c\">\n" +
                " <div class=\"tips\">0</div>\n" +
                " <div class=\"rpr\">65</div>\n" +
                " <div class=\"ts\">-</div>\n" +
                " </td>\n" +
                " <td class=\"two jt\">\n" +
                " <div>\n" +
                " <a href=\"http://www.racingpost.com/horses/trainer_home.sd?trainer_id=995\" onclick=\"scorecards.send(&quot;trainer_name&quot;);return Html.popup(this, {width:695, height:800})\" title=\"Full details about this TRAINER\">J S Bolger</a><sup><span title=\"the percentage of the stable's runners that have Run To Form in the last 14 days, based on RPR\">62</span></sup> </div>\n" +
                " <div>\n" +
                " <a href=\"http://www.racingpost.com/horses/jockey_home.sd?jockey_id=2102\" onclick=\"scorecards.send(&quot;jockey_name&quot;);return Html.popup(this, {width:695, height:800})\" title=\"Full details about this JOCKEY\">Kevin Manning</a> </div>\n" +
                " </td>\n" +
                " <td class=\"two awo\">\n" +
                " <div>\n" +
                " 2 &nbsp;\n" +
                " 9-5 </div>\n" +
                " <div>\n" +
                " - </div>\n" +
                " </td>\n" +
                " <td class=\"bk\" id=\"sc_61564723_bk\"><strong class=\"noBetting\">No betting</strong></td>\n" +
                " </tr>\n" +
                " <tr>\n" +
                " <td class=\"cardItemInfo\" colspan=\"7\">\n" +
                " <p class=\"diomed\">\n" +
                " Arrives from an in-form yard, has to be shown some respect </p>\n" +
                " <div class=\"forms\">\n" +
                " <table class=\"grid smallSpaceGrid\">\n" +
                " <tbody><tr class=\"noSpace\">\n" +
                " <th class=\"v\">&nbsp;</th>\n" +
                " <th class=\"date\">DATE</th>\n" +
                " <th class=\"raceCond\">RACE CONDITIONS</th>\n" +
                " <th class=\"wgt\">WGT</th>\n" +
                " <th class=\"raceOut\">RACE OUTCOME</th>\n" +
                " <th class=\"jock\">JOCKEY</th>\n" +
                " <th class=\"num\">OR</th>\n" +
                " <th class=\"num\">TS</th>\n" +
                " <th class=\"num last\">RPR</th>\n" +
                " </tr>\n" +
                " <tr>\n" +
                " <td class=\"v\"><a href=\"#\" onclick=\"scorecards.sendSpecificDesc(&quot;ruk_video&quot;, &quot;178, 2012-10-16, 12:00&quot;);panels.mediaCentre.replayPopup($(this), 565793, 818910, '2012-10-16', 'RUK'); return false;\"><img src=\"http://ui.racingpost.com/release/v17/ico/video.17.0.gif\" alt=\"Video\" title=\"Video\"></a></td>\n" +
                " <td>\n" +
                " <a href=\"http://www.racingpost.com/horses/result_home.sd?race_id=565793&amp;r_date=2012-10-16&amp;popup=yes\" onclick=\"scorecards.send(565793);return Html.popup(this, {width:695, height:800})\" title=\"Curragh Dining &amp; Hospitality Options 2013 Maiden\">16Oct12</a> &nbsp;\n" +
                " </td>\n" +
                " <td>\n" +
                " <b class=\"black\">\n" +
                " <a href=\"http://www.racingpost.com/horses/course_home.sd?crs_id=178\" onclick=\"return Html.popup(this, {width:695, height:800})\" title=\"Course (Click to view details): right-handed, galloping, testing, horseshoe (2m) + chute (races up to 1m)\">Cur</a> 7Hy </b>\n" +
                " 2y 5K </td>\n" +
                " <td>9-5</td>\n" +
                " <td>\n" +
                " <b class=\"black\">3</b>/6 <a href=\"http://www.racingpost.com/horses/result_home.sd?race_id=565793&amp;r_date=&amp;popup=yes\" onclick=\"scorecards.send(565793);return Html.popup(this, {width:695, height:800})\" title=\"close up 3rd, pushed along in 2nd 2f out, soon ridden and no impression on winner, one pace final furlong\">(5?L Kingdom 9-5)</a> 4/1 </td>\n" +
                " <td>\n" +
                " <a href=\"http://www.racingpost.com/horses/jockey_home.sd?jockey_id=2102\" onclick=\"scorecards.send(&quot;jockey_name&quot;);return Html.popup(this, {width:695, height:800})\" title=\"Full details about this JOCKEY\">Kevin Manning</a> </td>\n" +
                " <td class=\"num\">-</td>\n" +
                " <td class=\"num\"><span class=\"red bold\">*</span></td>\n" +
                " <td class=\"num last\"><span class=\"red bold\">*</span></td>\n" +
                " </tr>\n" +
                " <tr>\n" +
                " <td class=\"v\"><a href=\"#\" onclick=\"scorecards.sendSpecificDesc(&quot;ruk_video&quot;, &quot;1138, 2012-09-28, 12:00&quot;);panels.mediaCentre.replayPopup($(this), 564641, 818910, '2012-09-28', 'RUK'); return false;\"><img src=\"http://ui.racingpost.com/release/v17/ico/video.17.0.gif\" alt=\"Video\" title=\"Video\"></a></td>\n" +
                " <td>\n" +
                " <a href=\"http://www.racingpost.com/horses/result_home.sd?race_id=564641&amp;r_date=2012-09-28&amp;popup=yes\" onclick=\"scorecards.send(564641);return Html.popup(this, {width:695, height:800})\" title=\"Irish Stallion Farms European Breeders Fund Maiden\">28Sep12</a> &nbsp;\n" +
                " </td>\n" +
                " <td>\n" +
                " <b class=\"black\">\n" +
                " <a href=\"http://www.racingpost.com/horses/course_home.sd?crs_id=1138\" onclick=\"return Html.popup(this, {width:695, height:800})\" title=\"Course (Click to view details): AW Polytrack: left-handed (1m2f oval).\">Dun</a> 8St </b>\n" +
                " 2y 7K </td>\n" +
                " <td>9-5</td>\n" +
                " <td>\n" +
                " <b class=\"black\">9</b>/13 <a href=\"http://www.racingpost.com/horses/result_home.sd?race_id=564641&amp;r_date=&amp;popup=yes\" onclick=\"scorecards.send(564641);return Html.popup(this, {width:695, height:800})\" title=\"in rear of mid-division, ridden over 3f out, no impression\">(10?L Fighter Squadron 9-5)</a> 9/2 </td>\n" +
                " <td>\n" +
                " <a href=\"http://www.racingpost.com/horses/jockey_home.sd?jockey_id=2102\" onclick=\"scorecards.send(&quot;jockey_name&quot;);return Html.popup(this, {width:695, height:800})\" title=\"Full details about this JOCKEY\">Kevin Manning</a> </td>\n" +
                " <td class=\"num\">-</td>\n" +
                " <td class=\"num\"><span class=\"red bold\">*</span></td>\n" +
                " <td class=\"num last\"><span class=\"red bold\">*</span></td>\n" +
                " </tr>\n" +
                " </tbody></table>\n" +
                " <span id=\"barrier_RPR-TS_In_Form2542462259\" class=\"bar prpTsInfo\"><span id=\"ruli_33\"><span class=\"red bold\">*</span> Historical RP Ratings and Topspeed Ratings are part of Racing Post Members' Club <a href=\"#\" class=\"blue\" onclick=\"javascript:callLogin('special_offer');\"> Log in to view</a></span></span></div>\n" +
                "<div id=\"sc_raceHorseNotes_818910\" class=\"notes\" style=\"display: none; \"></div>\n" +
                "\n" +
                " </td>\n" +
                " </tr>\n" +
                " <tr>\n" +
                " <td colspan=\"7\"><tt><i></i></tt></td>\n" +
                " </tr>\n" +
                " </tbody><tbody id=\"sc_61564722\">\n" +
                " <tr class=\"cr\">\n" +
                " <td class=\"t\">\n" +
                " <strong>6</strong><sup>2</sup> <em><b>0</b>85</em>\n" +
                " </td>\n" +
                " <td class=\"s\">\n" +
                " <a href=\"http://www.racingpost.com/horses/owner_home.sd?owner_id=20157\" onclick=\"scorecards.send(&quot;owner_name&quot;);return Html.popup(this, {width:695, height:800})\" title=\"Full details about this OWNER\"><img src=\"http://images.racingpost.com/png_silks/b/7/5/20157b.png\" class=\"iepng\" alt=\"Owner details\" title=\"Full details about this OWNER\" width=\"40\" height=\"29\"></a> </td>\n" +
                " \n" +
                " <td class=\"h\">\n" +
                " <div class=\"nm\">\n" +
                " <a href=\"http://www.racingpost.com/horses/horse_home.sd?race_id=565793&amp;r_date=2012-10-16&amp;horse_id=816846\" onclick=\"scorecards.send(&quot;horse_name&quot;);return Html.popup(this, {width:695, height:800})\" title=\"Full details about this HORSE\"><b>TALE OF FAME</b></a> \n" +
                " <a href=\"#\" id=\"sc_pencil_816846\" title=\"Show/Hide My Notes for this runner\"></a> </div>\n" +
                "\n" +
                " <div class=\"oddsBar\">\n" +
                " <div><div style=\"width: 4%\"></div></div>\n" +
                " <span>4%</span>\n" +
                " </div>\n" +
                " </td>\n" +
                " <td class=\"two c\">\n" +
                " <div class=\"tips\">0</div>\n" +
                " <div class=\"rpr\">55</div>\n" +
                " <div class=\"ts\">44 </div>\n" +
                " </td>\n" +
                " <td class=\"two jt\">\n" +
                " <div>\n" +
                " <a href=\"http://www.racingpost.com/horses/trainer_home.sd?trainer_id=14326\" onclick=\"scorecards.send(&quot;trainer_name&quot;);return Html.popup(this, {width:695, height:800})\" title=\"Full details about this TRAINER\">F Costello</a> </div>\n" +
                " <div>\n" +
                " <a href=\"http://www.racingpost.com/horses/jockey_home.sd?jockey_id=11184\" onclick=\"scorecards.send(&quot;jockey_name&quot;);return Html.popup(this, {width:695, height:800})\" title=\"Full details about this JOCKEY\">Pat Smullen</a> </div>\n" +
                " </td>\n" +
                " <td class=\"two awo\">\n" +
                " <div>\n" +
                " 2 &nbsp;\n" +
                " 9-5 </div>\n" +
                " <div>\n" +
                " - </div>\n" +
                " </td>\n" +
                " <td class=\"bk\" id=\"sc_61564722_bk\"><strong class=\"noBetting\">No betting</strong></td>\n" +
                " </tr>\n" +
                " <tr>\n" +
                " <td class=\"cardItemInfo\" colspan=\"7\">\n" +
                " <p class=\"diomed\">\n" +
                " Hopes of a big run are not glaringly obvious, unproven on this surface </p>\n" +
                " <div class=\"forms\">\n" +
                " <table class=\"grid smallSpaceGrid\">\n" +
                " <tbody><tr class=\"noSpace\">\n" +
                " <th class=\"v\">&nbsp;</th>\n" +
                " <th class=\"date\">DATE</th>\n" +
                " <th class=\"raceCond\">RACE CONDITIONS</th>\n" +
                " <th class=\"wgt\">WGT</th>\n" +
                " <th class=\"raceOut\">RACE OUTCOME</th>\n" +
                " <th class=\"jock\">JOCKEY</th>\n" +
                " <th class=\"num\">OR</th>\n" +
                " <th class=\"num\">TS</th>\n" +
                " <th class=\"num last\">RPR</th>\n" +
                " </tr>\n" +
                " <tr>\n" +
                " <td class=\"v\"><a href=\"#\" onclick=\"scorecards.sendSpecificDesc(&quot;ruk_video&quot;, &quot;178, 2012-10-16, 12:00&quot;);panels.mediaCentre.replayPopup($(this), 565793, 816846, '2012-10-16', 'RUK'); return false;\"><img src=\"http://ui.racingpost.com/release/v17/ico/video.17.0.gif\" alt=\"Video\" title=\"Video\"></a></td>\n" +
                " <td>\n" +
                " <a href=\"http://www.racingpost.com/horses/result_home.sd?race_id=565793&amp;r_date=2012-10-16&amp;popup=yes\" onclick=\"scorecards.send(565793);return Html.popup(this, {width:695, height:800})\" title=\"Curragh Dining &amp; Hospitality Options 2013 Maiden\">16Oct12</a> &nbsp;\n" +
                " </td>\n" +
                " <td>\n" +
                " <b class=\"black\">\n" +
                " <a href=\"http://www.racingpost.com/horses/course_home.sd?crs_id=178\" onclick=\"return Html.popup(this, {width:695, height:800})\" title=\"Course (Click to view details): right-handed, galloping, testing, horseshoe (2m) + chute (races up to 1m)\">Cur</a> 7Hy </b>\n" +
                " 2y 5K </td>\n" +
                " <td>9-5</td>\n" +
                " <td>\n" +
                " <b class=\"black\">5</b>/6 <a href=\"http://www.racingpost.com/horses/result_home.sd?race_id=565793&amp;r_date=&amp;popup=yes\" onclick=\"scorecards.send(565793);return Html.popup(this, {width:695, height:800})\" title=\"chased winner in 2nd, pushed along over 2f out and soon weakened\">(15L Kingdom 9-5)</a> 33/1 </td>\n" +
                " <td>\n" +
                " <a href=\"http://www.racingpost.com/horses/jockey_home.sd?jockey_id=7605\" onclick=\"scorecards.send(&quot;jockey_name&quot;);return Html.popup(this, {width:695, height:800})\" title=\"Full details about this JOCKEY\">Seamie Heffernan</a> </td>\n" +
                " <td class=\"num\">-</td>\n" +
                " <td class=\"num\"><span class=\"red bold\">*</span></td>\n" +
                " <td class=\"num last\"><span class=\"red bold\">*</span></td>\n" +
                " </tr>\n" +
                " <tr>\n" +
                " <td class=\"v\"><a href=\"#\" onclick=\"scorecards.sendSpecificDesc(&quot;ruk_video&quot;, &quot;180, 2012-09-14, 12:00&quot;);panels.mediaCentre.replayPopup($(this), 563869, 816846, '2012-09-14', 'RUK'); return false;\"><img src=\"http://ui.racingpost.com/release/v17/ico/video.17.0.gif\" alt=\"Video\" title=\"Video\"></a></td>\n" +
                " <td>\n" +
                " <a href=\"http://www.racingpost.com/horses/result_home.sd?race_id=563869&amp;r_date=2012-09-14&amp;popup=yes\" onclick=\"scorecards.send(563869);return Html.popup(this, {width:695, height:800})\" title=\"Hobbs Claiming Race\">14Sep12</a> &nbsp;\n" +
                " </td>\n" +
                " <td>\n" +
                " <b class=\"black\">\n" +
                " <a href=\"http://www.racingpost.com/horses/course_home.sd?crs_id=180\" onclick=\"return Html.popup(this, {width:695, height:800})\" title=\"Course (Click to view details): right-handed, galloping, undulating, testing (1m7f circuit + 5f chute)\">Dro</a> 7Y </b>\n" +
                " 2yCl 4K </td>\n" +
                " <td>9-8</td>\n" +
                " <td>\n" +
                " <b class=\"black\">8</b>/13 <a href=\"http://www.racingpost.com/horses/result_home.sd?race_id=563869&amp;r_date=&amp;popup=yes\" onclick=\"scorecards.send(563869);return Html.popup(this, {width:695, height:800})\" title=\"held up on inner, never a threat, some late headway\">(11L Fromajacktoaking 9-0)</a> 25/1 </td>\n" +
                " <td>\n" +
                " <a href=\"http://www.racingpost.com/horses/jockey_home.sd?jockey_id=7605\" onclick=\"scorecards.send(&quot;jockey_name&quot;);return Html.popup(this, {width:695, height:800})\" title=\"Full details about this JOCKEY\">Seamie Heffernan</a> </td>\n" +
                " <td class=\"num\">-</td>\n" +
                " <td class=\"num\"><span class=\"red bold\">*</span></td>\n" +
                " <td class=\"num last\"><span class=\"red bold\">*</span></td>\n" +
                " </tr>\n" +
                " <tr>\n" +
                " <td class=\"v\"><a href=\"#\" onclick=\"scorecards.sendSpecificDesc(&quot;ruk_video&quot;, &quot;1138, 2012-08-27, 12:00&quot;);panels.mediaCentre.replayPopup($(this), 562960, 816846, '2012-08-27', 'RUK'); return false;\"><img src=\"http://ui.racingpost.com/release/v17/ico/video.17.0.gif\" alt=\"Video\" title=\"Video\"></a></td>\n" +
                " <td>\n" +
                " <a href=\"http://www.racingpost.com/horses/result_home.sd?race_id=562960&amp;r_date=2012-08-27&amp;popup=yes\" onclick=\"scorecards.send(562960);return Html.popup(this, {width:695, height:800})\" title=\"info@dundalkstadium.com Maiden\">27Aug12</a> &nbsp;\n" +
                " </td>\n" +
                " <td>\n" +
                " <b class=\"black\">\n" +
                " <a href=\"http://www.racingpost.com/horses/course_home.sd?crs_id=1138\" onclick=\"return Html.popup(this, {width:695, height:800})\" title=\"Course (Click to view details): AW Polytrack: left-handed (1m2f oval).\">Dun</a> 5St </b>\n" +
                " 2y 5K </td>\n" +
                " <td>9-5</td>\n" +
                " <td>\n" +
                " <b class=\"black\">11</b>/12 <a href=\"http://www.racingpost.com/horses/result_home.sd?race_id=562960&amp;r_date=&amp;popup=yes\" onclick=\"scorecards.send(562960);return Html.popup(this, {width:695, height:800})\" title=\"always towards rear\">(14L Vinson Massif 9-5)</a> 25/1 </td>\n" +
                " <td>\n" +
                " <a href=\"http://www.racingpost.com/horses/jockey_home.sd?jockey_id=2456\" onclick=\"scorecards.send(&quot;jockey_name&quot;);return Html.popup(this, {width:695, height:800})\" title=\"Full details about this JOCKEY\">J F Egan</a> </td>\n" +
                " <td class=\"num\">-</td>\n" +
                " <td class=\"num\"><span class=\"red bold\">*</span></td>\n" +
                " <td class=\"num last\"><span class=\"red bold\">*</span></td>\n" +
                " </tr>\n" +
                " </tbody></table>\n" +
                " <span id=\"barrier_RPR-TS_In_Form61202711313\" class=\"bar prpTsInfo\"><span id=\"ruli_33\"><span class=\"red bold\">*</span> Historical RP Ratings and Topspeed Ratings are part of Racing Post Members' Club <a href=\"#\" class=\"blue\" onclick=\"javascript:callLogin('special_offer');\"> Log in to view</a></span></span></div>\n" +
                "<div id=\"sc_raceHorseNotes_816846\" class=\"notes\" style=\"display: none; \"></div>\n" +
                "\n" +
                " </td>\n" +
                " </tr>\n" +
                " <tr>\n" +
                " <td colspan=\"7\"><tt><i></i></tt></td>\n" +
                " </tr>\n" +
                " </tbody><tbody id=\"sc_61564725\">\n" +
                " <tr class=\"cr\">\n" +
                " <td class=\"t\">\n" +
                " <strong>7</strong><sup>5</sup> <em>2</em>\n" +
                " </td>\n" +
                " <td class=\"s\">\n" +
                " <a href=\"http://www.racingpost.com/horses/owner_home.sd?owner_id=90224\" onclick=\"scorecards.send(&quot;owner_name&quot;);return Html.popup(this, {width:695, height:800})\" title=\"Full details about this OWNER\"><img src=\"http://images.racingpost.com/png_silks/4/2/2/90224.png\" class=\"iepng\" alt=\"Owner details\" title=\"Full details about this OWNER\" width=\"40\" height=\"29\"></a> </td>\n" +
                " \n" +
                " <td class=\"h\">\n" +
                " <div class=\"nm\">\n" +
                " <a href=\"http://www.racingpost.com/horses/horse_home.sd?race_id=565793&amp;r_date=2012-10-16&amp;horse_id=821766\" onclick=\"scorecards.send(&quot;horse_name&quot;);return Html.popup(this, {width:695, height:800})\" title=\"Full details about this HORSE\"><b>PAY DAY KITTEN</b></a> \n" +
                " <a href=\"#\" id=\"sc_pencil_821766\" title=\"Show/Hide My Notes for this runner\"></a> </div>\n" +
                "\n" +
                " <div class=\"oddsBar\">\n" +
                " <div><div style=\"width: 6%\"></div></div>\n" +
                " <span>6%</span>\n" +
                " </div>\n" +
                " </td>\n" +
                " <td class=\"two c\">\n" +
                " <div class=\"tips\">0</div>\n" +
                " <div class=\"rpr\">-</div>\n" +
                " <div class=\"ts\">-</div>\n" +
                " </td>\n" +
                " <td class=\"two jt\">\n" +
                " <div>\n" +
                " <a href=\"http://www.racingpost.com/horses/trainer_home.sd?trainer_id=1010\" onclick=\"scorecards.send(&quot;trainer_name&quot;);return Html.popup(this, {width:695, height:800})\" title=\"Full details about this TRAINER\">D K Weld</a><sup><span title=\"the percentage of the stable's runners that have Run To Form in the last 14 days, based on RPR\">35</span></sup> </div>\n" +
                " <div>\n" +
                " <a href=\"http://www.racingpost.com/horses/jockey_home.sd?jockey_id=81407\" onclick=\"scorecards.send(&quot;jockey_name&quot;);return Html.popup(this, {width:695, height:800})\" title=\"Full details about this JOCKEY\">Shane Gorey</a><sup>3</sup> </div>\n" +
                " </td>\n" +
                " <td class=\"two awo\">\n" +
                " <div>\n" +
                " 2 &nbsp;\n" +
                " 9-0 </div>\n" +
                " <div>\n" +
                " - </div>\n" +
                " </td>\n" +
                " <td class=\"bk\" id=\"sc_61564725_bk\"><strong class=\"noBetting\">No betting</strong></td>\n" +
                " </tr>\n" +
                " <tr>\n" +
                " <td class=\"cardItemInfo\" colspan=\"7\">\n" +
                " <p class=\"diomed\">\n" +
                " Yard has won with a runner here on debut before, unfancied even so </p>\n" +
                " <div class=\"forms\">\n" +
                " <table class=\"grid smallSpaceGrid\">\n" +
                " <tbody><tr class=\"noSpace\">\n" +
                " <th class=\"v\">&nbsp;</th>\n" +
                " <th class=\"date\">DATE</th>\n" +
                " <th class=\"raceCond\">RACE CONDITIONS</th>\n" +
                " <th class=\"wgt\">WGT</th>\n" +
                " <th class=\"raceOut\">RACE OUTCOME</th>\n" +
                " <th class=\"jock\">JOCKEY</th>\n" +
                " <th class=\"num\">OR</th>\n" +
                " <th class=\"num\">TS</th>\n" +
                " <th class=\"num last\">RPR</th>\n" +
                " </tr>\n" +
                " <tr>\n" +
                " <td class=\"v\"><a href=\"#\" onclick=\"scorecards.sendSpecificDesc(&quot;ruk_video&quot;, &quot;178, 2012-10-16, 12:00&quot;);panels.mediaCentre.replayPopup($(this), 565793, 821766, '2012-10-16', 'RUK'); return false;\"><img src=\"http://ui.racingpost.com/release/v17/ico/video.17.0.gif\" alt=\"Video\" title=\"Video\"></a></td>\n" +
                " <td>\n" +
                " <a href=\"http://www.racingpost.com/horses/result_home.sd?race_id=565793&amp;r_date=2012-10-16&amp;popup=yes\" onclick=\"scorecards.send(565793);return Html.popup(this, {width:695, height:800})\" title=\"Curragh Dining &amp; Hospitality Options 2013 Maiden\">16Oct12</a> &nbsp;\n" +
                " </td>\n" +
                " <td>\n" +
                " <b class=\"black\">\n" +
                " <a href=\"http://www.racingpost.com/horses/course_home.sd?crs_id=178\" onclick=\"return Html.popup(this, {width:695, height:800})\" title=\"Course (Click to view details): right-handed, galloping, testing, horseshoe (2m) + chute (races up to 1m)\">Cur</a> 7Hy </b>\n" +
                " 2y 5K </td>\n" +
                " <td>9-0</td>\n" +
                " <td>\n" +
                " <b class=\"black\">2</b>/6 <a href=\"http://www.racingpost.com/horses/result_home.sd?race_id=565793&amp;r_date=&amp;popup=yes\" onclick=\"scorecards.send(565793);return Html.popup(this, {width:695, height:800})\" title=\"held up in 4th, pushed along under 3f out, went 3rd 1 1/2f out, soon switched right and ran on well to strongly press winner towards finish, just held\">(?L Kingdom 9-5)</a> 10/1 </td>\n" +
                " <td>\n" +
                " <a href=\"http://www.racingpost.com/horses/jockey_home.sd?jockey_id=11184\" onclick=\"scorecards.send(&quot;jockey_name&quot;);return Html.popup(this, {width:695, height:800})\" title=\"Full details about this JOCKEY\">Pat Smullen</a> </td>\n" +
                " <td class=\"num\">-</td>\n" +
                " <td class=\"num\"><span class=\"red bold\">*</span></td>\n" +
                " <td class=\"num last\"><span class=\"red bold\">*</span></td>\n" +
                " </tr>\n" +
                " </tbody></table>\n" +
                " <span id=\"barrier_RPR-TS_In_Form41364508672\" class=\"bar prpTsInfo\"><span id=\"ruli_33\"><span class=\"red bold\">*</span> Historical RP Ratings and Topspeed Ratings are part of Racing Post Members' Club <a href=\"#\" class=\"blue\" onclick=\"javascript:callLogin('special_offer');\"> Log in to view</a></span></span></div>\n" +
                "<div id=\"sc_raceHorseNotes_821766\" class=\"notes\" style=\"display: none; \"></div>\n" +
                "\n" +
                " </td>\n" +
                " </tr>\n" +
                " <tr>\n" +
                " <td colspan=\"7\"><tt><i></i></tt></td>\n" +
                " </tr>\n" +
                " </tbody>\n" +
                " </table>";
    }
}
