package oriolvillaret.com.speedrun.models.mappers;

import com.google.gson.Gson;

import org.junit.Test;

import java.util.ArrayList;

import oriolvillaret.com.speedrun.models.Game;

import static org.junit.Assert.assertEquals;


public class GameMapperTest {

    String game1 = "{\"id\":\"k6qqkx6g\",\"names\":{\"international\":\"! Fishy !\",\"japanese\":null,\"twitch\":\"! Fishy !\"},\"abbreviation\":\"fishy\",\"weblink\":\"https://www.speedrun.com/fishy\",\"released\":2003,\"release-date\":\"2003-02-02\",\"ruleset\":{\"show-milliseconds\":false,\"require-verification\":true,\"require-video\":true,\"run-times\":[\"realtime\"],\"default-time\":\"realtime\",\"emulators-allowed\":false},\"romhack\":false,\"gametypes\":[],\"platforms\":[\"o7e25xew\"],\"regions\":[],\"genres\":[],\"engines\":[\"mg1j4w1r\"],\"developers\":[\"veg7rpe0\"],\"publishers\":[],\"moderators\":{\"mkj9nw84\":\"super-moderator\"},\"created\":\"2016-05-28T23:21:12Z\",\"assets\":{\"logo\":{\"uri\":\"https://www.speedrun.com/themes/fishy/logo.png\",\"width\":180,\"height\":22},\"cover-tiny\":{\"uri\":\"https://www.speedrun.com/themes/fishy/cover-32.png\",\"width\":45,\"height\":32},\"cover-small\":{\"uri\":\"https://www.speedrun.com/themes/fishy/cover-64.png\",\"width\":90,\"height\":64},\"cover-medium\":{\"uri\":\"https://www.speedrun.com/themes/fishy/cover-128.png\",\"width\":180,\"height\":128},\"cover-large\":{\"uri\":\"https://www.speedrun.com/themes/fishy/cover-256.png\",\"width\":360,\"height\":256},\"icon\":{\"uri\":\"https://www.speedrun.com/themes/fishy/favicon.png\",\"width\":32,\"height\":32},\"trophy-1st\":{\"uri\":\"https://www.speedrun.com/themes/fishy/1st.png\",\"width\":16,\"height\":15},\"trophy-2nd\":{\"uri\":\"https://www.speedrun.com/themes/fishy/2nd.png\",\"width\":16,\"height\":15},\"trophy-3rd\":{\"uri\":\"https://www.speedrun.com/themes/fishy/3rd.png\",\"width\":16,\"height\":15},\"trophy-4th\":null,\"background\":{\"uri\":\"https://www.speedrun.com/themes/fishy/background.png\",\"width\":1400,\"height\":998},\"foreground\":{\"uri\":\"https://www.speedrun.com/themes/fishy/foreground.png\",\"width\":200,\"height\":74}},\"links\":[{\"rel\":\"self\",\"uri\":\"https://www.speedrun.com/api/v1/games/k6qqkx6g\"},{\"rel\":\"runs\",\"uri\":\"https://www.speedrun.com/api/v1/runs?game=k6qqkx6g\"},{\"rel\":\"levels\",\"uri\":\"https://www.speedrun.com/api/v1/games/k6qqkx6g/levels\"},{\"rel\":\"categories\",\"uri\":\"https://www.speedrun.com/api/v1/games/k6qqkx6g/categories\"},{\"rel\":\"variables\",\"uri\":\"https://www.speedrun.com/api/v1/games/k6qqkx6g/variables\"},{\"rel\":\"records\",\"uri\":\"https://www.speedrun.com/api/v1/games/k6qqkx6g/records\"},{\"rel\":\"series\",\"uri\":\"https://www.speedrun.com/api/v1/series/yr4gon12\"},{\"rel\":\"derived-games\",\"uri\":\"https://www.speedrun.com/api/v1/games/k6qqkx6g/derived-games\"},{\"rel\":\"romhacks\",\"uri\":\"https://www.speedrun.com/api/v1/games/k6qqkx6g/derived-games\"},{\"rel\":\"leaderboard\",\"uri\":\"https://www.speedrun.com/api/v1/leaderboards/k6qqkx6g/category/rklgq3rd\"}]}";
    String game2 = "{\"id\":\"46wxo91r\",\"names\":{\"international\":\"&meow; (Meow)\",\"japanese\":null,\"twitch\":\"ᗢ (Meow)\"},\"abbreviation\":\"meow\",\"weblink\":\"https://www.speedrun.com/meow\",\"released\":2016,\"release-date\":\"2016-05-28\",\"ruleset\":{\"show-milliseconds\":false,\"require-verification\":true,\"require-video\":true,\"run-times\":[\"realtime\"],\"default-time\":\"realtime\",\"emulators-allowed\":true},\"romhack\":false,\"gametypes\":[],\"platforms\":[\"8gej2n93\",\"mx6ppw63\"],\"regions\":[],\"genres\":[],\"engines\":[],\"developers\":[],\"publishers\":[],\"moderators\":{\"zxz9kn8q\":\"super-moderator\"},\"created\":\"2016-08-08T19:48:46Z\",\"assets\":{\"logo\":{\"uri\":\"https://www.speedrun.com/themes/Default/logo.png\",\"width\":640,\"height\":78},\"cover-tiny\":{\"uri\":\"https://www.speedrun.com/themes/meow/cover-32.png\",\"width\":32,\"height\":37},\"cover-small\":{\"uri\":\"https://www.speedrun.com/themes/meow/cover-64.png\",\"width\":64,\"height\":74},\"cover-medium\":{\"uri\":\"https://www.speedrun.com/themes/meow/cover-128.png\",\"width\":128,\"height\":148},\"cover-large\":{\"uri\":\"https://www.speedrun.com/themes/meow/cover-256.png\",\"width\":256,\"height\":296},\"icon\":{\"uri\":\"https://www.speedrun.com/themes/meow/favicon.png\",\"width\":55,\"height\":64},\"trophy-1st\":{\"uri\":\"https://www.speedrun.com/themes/Default/1st.png\",\"width\":64,\"height\":64},\"trophy-2nd\":{\"uri\":\"https://www.speedrun.com/themes/Default/2nd.png\",\"width\":64,\"height\":64},\"trophy-3rd\":{\"uri\":\"https://www.speedrun.com/themes/Default/3rd.png\",\"width\":64,\"height\":64},\"trophy-4th\":null,\"background\":{\"uri\":\"https://www.speedrun.com/themes/meow/background.png\",\"width\":1920,\"height\":1080},\"foreground\":{\"uri\":\"https://www.speedrun.com/themes/meow/foreground.png\",\"width\":1500,\"height\":300}},\"links\":[{\"rel\":\"self\",\"uri\":\"https://www.speedrun.com/api/v1/games/46wxo91r\"},{\"rel\":\"runs\",\"uri\":\"https://www.speedrun.com/api/v1/runs?game=46wxo91r\"},{\"rel\":\"levels\",\"uri\":\"https://www.speedrun.com/api/v1/games/46wxo91r/levels\"},{\"rel\":\"categories\",\"uri\":\"https://www.speedrun.com/api/v1/games/46wxo91r/categories\"},{\"rel\":\"variables\",\"uri\":\"https://www.speedrun.com/api/v1/games/46wxo91r/variables\"},{\"rel\":\"records\",\"uri\":\"https://www.speedrun.com/api/v1/games/46wxo91r/records\"},{\"rel\":\"series\",\"uri\":\"https://www.speedrun.com/api/v1/series/yr4gon12\"},{\"rel\":\"derived-games\",\"uri\":\"https://www.speedrun.com/api/v1/games/46wxo91r/derived-games\"},{\"rel\":\"romhacks\",\"uri\":\"https://www.speedrun.com/api/v1/games/46wxo91r/derived-games\"},{\"rel\":\"leaderboard\",\"uri\":\"https://www.speedrun.com/api/v1/leaderboards/46wxo91r/category/w20zx3vd\"}]}";
    String game3 = "{\"id\":\"pdvp7kdw\",\"names\":{\"international\":\"'Allo 'Allo! Cartoon Fun!\",\"japanese\":null,\"twitch\":\"'Allo 'Allo! Cartoon Fun!\"},\"abbreviation\":\"Allo_Allo_Cartoon_Fun\",\"weblink\":\"https://www.speedrun.com/Allo_Allo_Cartoon_Fun\",\"released\":1993,\"release-date\":\"1993-01-01\",\"ruleset\":{\"show-milliseconds\":false,\"require-verification\":true,\"require-video\":true,\"run-times\":[\"realtime\"],\"default-time\":\"realtime\",\"emulators-allowed\":true},\"romhack\":false,\"gametypes\":[],\"platforms\":[\"gde32g6k\"],\"regions\":[\"e6lxy1dz\"],\"genres\":[\"94n4pn0w\",\"qdnqkn8k\",\"pm21dr24\"],\"engines\":[],\"developers\":[\"w63pojzx\"],\"publishers\":[\"06022yrl\"],\"moderators\":{\"kj92on84\":\"moderator\",\"98r77gj1\":\"super-moderator\"},\"created\":\"2015-10-16T13:50:43Z\",\"assets\":{\"logo\":{\"uri\":\"https://www.speedrun.com/themes/Default/logo.png\",\"width\":640,\"height\":78},\"cover-tiny\":{\"uri\":\"https://www.speedrun.com/themes/Allo_Allo_Cartoon_Fun/cover-32.png\",\"width\":32,\"height\":41},\"cover-small\":{\"uri\":\"https://www.speedrun.com/themes/Allo_Allo_Cartoon_Fun/cover-64.png\",\"width\":64,\"height\":82},\"cover-medium\":{\"uri\":\"https://www.speedrun.com/themes/Allo_Allo_Cartoon_Fun/cover-128.png\",\"width\":128,\"height\":164},\"cover-large\":{\"uri\":\"https://www.speedrun.com/themes/Allo_Allo_Cartoon_Fun/cover-256.png\",\"width\":256,\"height\":328},\"icon\":{\"uri\":\"https://www.speedrun.com/themes/Default/favicon.png\",\"width\":64,\"height\":64},\"trophy-1st\":{\"uri\":\"https://www.speedrun.com/themes/Default/1st.png\",\"width\":64,\"height\":64},\"trophy-2nd\":{\"uri\":\"https://www.speedrun.com/themes/Default/2nd.png\",\"width\":64,\"height\":64},\"trophy-3rd\":{\"uri\":\"https://www.speedrun.com/themes/Default/3rd.png\",\"width\":64,\"height\":64},\"trophy-4th\":null,\"background\":null,\"foreground\":null},\"links\":[{\"rel\":\"self\",\"uri\":\"https://www.speedrun.com/api/v1/games/pdvp7kdw\"},{\"rel\":\"runs\",\"uri\":\"https://www.speedrun.com/api/v1/runs?game=pdvp7kdw\"},{\"rel\":\"levels\",\"uri\":\"https://www.speedrun.com/api/v1/games/pdvp7kdw/levels\"},{\"rel\":\"categories\",\"uri\":\"https://www.speedrun.com/api/v1/games/pdvp7kdw/categories\"},{\"rel\":\"variables\",\"uri\":\"https://www.speedrun.com/api/v1/games/pdvp7kdw/variables\"},{\"rel\":\"records\",\"uri\":\"https://www.speedrun.com/api/v1/games/pdvp7kdw/records\"},{\"rel\":\"series\",\"uri\":\"https://www.speedrun.com/api/v1/series/yr4gon12\"},{\"rel\":\"derived-games\",\"uri\":\"https://www.speedrun.com/api/v1/games/pdvp7kdw/derived-games\"},{\"rel\":\"romhacks\",\"uri\":\"https://www.speedrun.com/api/v1/games/pdvp7kdw/derived-games\"},{\"rel\":\"leaderboard\",\"uri\":\"https://www.speedrun.com/api/v1/leaderboards/pdvp7kdw/category/n2yqvoek\"}]}";
    String game4 = "{\"id\":\"m1m8opd2\",\"names\":{\"international\":\"'Splosion Man\",\"japanese\":null,\"twitch\":\"'Splosion Man\"},\"abbreviation\":\"Splosion_Man\",\"weblink\":\"https://www.speedrun.com/Splosion_Man\",\"released\":2009,\"release-date\":\"2009-07-22\",\"ruleset\":{\"show-milliseconds\":true,\"require-verification\":true,\"require-video\":true,\"run-times\":[\"realtime\",\"ingame\"],\"default-time\":\"realtime\",\"emulators-allowed\":true},\"romhack\":false,\"gametypes\":[],\"platforms\":[\"n568oevp\"],\"regions\":[\"pr184lqn\",\"e6lxy1dz\",\"o316x197\",\"p2g50lnk\"],\"genres\":[\"q5w3vk2g\"],\"engines\":[\"k3lqqm5v\"],\"developers\":[\"4epx49zr\"],\"publishers\":[\"56472j6w\"],\"moderators\":{\"zxzn14xq\":\"super-moderator\"},\"created\":\"2017-04-10T04:06:31Z\",\"assets\":{\"logo\":{\"uri\":\"https://www.speedrun.com/themes/Default/logo.png\",\"width\":640,\"height\":78},\"cover-tiny\":{\"uri\":\"https://www.speedrun.com/themes/Splosion_Man/cover-32.png\",\"width\":32,\"height\":45},\"cover-small\":{\"uri\":\"https://www.speedrun.com/themes/Splosion_Man/cover-64.png\",\"width\":64,\"height\":90},\"cover-medium\":{\"uri\":\"https://www.speedrun.com/themes/Splosion_Man/cover-128.png\",\"width\":128,\"height\":180},\"cover-large\":{\"uri\":\"https://www.speedrun.com/themes/Splosion_Man/cover-256.png\",\"width\":256,\"height\":360},\"icon\":{\"uri\":\"https://www.speedrun.com/themes/Default/favicon.png\",\"width\":64,\"height\":64},\"trophy-1st\":{\"uri\":\"https://www.speedrun.com/themes/Default/1st.png\",\"width\":64,\"height\":64},\"trophy-2nd\":{\"uri\":\"https://www.speedrun.com/themes/Default/2nd.png\",\"width\":64,\"height\":64},\"trophy-3rd\":{\"uri\":\"https://www.speedrun.com/themes/Default/3rd.png\",\"width\":64,\"height\":64},\"trophy-4th\":null,\"background\":null,\"foreground\":null},\"links\":[{\"rel\":\"self\",\"uri\":\"https://www.speedrun.com/api/v1/games/m1m8opd2\"},{\"rel\":\"runs\",\"uri\":\"https://www.speedrun.com/api/v1/runs?game=m1m8opd2\"},{\"rel\":\"levels\",\"uri\":\"https://www.speedrun.com/api/v1/games/m1m8opd2/levels\"},{\"rel\":\"categories\",\"uri\":\"https://www.speedrun.com/api/v1/games/m1m8opd2/categories\"},{\"rel\":\"variables\",\"uri\":\"https://www.speedrun.com/api/v1/games/m1m8opd2/variables\"},{\"rel\":\"records\",\"uri\":\"https://www.speedrun.com/api/v1/games/m1m8opd2/records\"},{\"rel\":\"series\",\"uri\":\"https://www.speedrun.com/api/v1/series/yr4gon12\"},{\"rel\":\"derived-games\",\"uri\":\"https://www.speedrun.com/api/v1/games/m1m8opd2/derived-games\"},{\"rel\":\"romhacks\",\"uri\":\"https://www.speedrun.com/api/v1/games/m1m8opd2/derived-games\"},{\"rel\":\"leaderboard\",\"uri\":\"https://www.speedrun.com/api/v1/leaderboards/m1m8opd2/category/5dwygl0k\"}]}";
    String game5 = "{\"id\":\"j1n4296p\",\"names\":{\"international\":\"'WWE Smackdown! Here Comes the Pain\",\"japanese\":null,\"twitch\":\"WWE Smackdown! Here Comes the Pain\"},\"abbreviation\":\"wwe_smackdown_here_comes_the_pain\",\"weblink\":\"https://www.speedrun.com/wwe_smackdown_here_comes_the_pain\",\"released\":2003,\"release-date\":\"2003-10-27\",\"ruleset\":{\"show-milliseconds\":false,\"require-verification\":true,\"require-video\":true,\"run-times\":[\"realtime\"],\"default-time\":\"realtime\",\"emulators-allowed\":true},\"romhack\":false,\"gametypes\":[],\"platforms\":[\"n5e17e27\"],\"regions\":[\"pr184lqn\",\"e6lxy1dz\",\"o316x197\"],\"genres\":[],\"engines\":[],\"developers\":[],\"publishers\":[],\"moderators\":{\"v8lo1v8m\":\"moderator\",\"qxkl4680\":\"super-moderator\",\"18v59dvj\":\"super-moderator\"},\"created\":\"2015-01-08T19:40:18Z\",\"assets\":{\"logo\":{\"uri\":\"https://www.speedrun.com/themes/wwe_smackdown_here_comes_the_pain/logo.png\",\"width\":180,\"height\":32},\"cover-tiny\":{\"uri\":\"https://www.speedrun.com/themes/wwe_smackdown_here_comes_the_pain/cover-32.png\",\"width\":32,\"height\":45},\"cover-small\":{\"uri\":\"https://www.speedrun.com/themes/wwe_smackdown_here_comes_the_pain/cover-64.png\",\"width\":64,\"height\":90},\"cover-medium\":{\"uri\":\"https://www.speedrun.com/themes/wwe_smackdown_here_comes_the_pain/cover-128.png\",\"width\":128,\"height\":180},\"cover-large\":{\"uri\":\"https://www.speedrun.com/themes/wwe_smackdown_here_comes_the_pain/cover-256.png\",\"width\":256,\"height\":360},\"icon\":{\"uri\":\"https://www.speedrun.com/themes/wwe_smackdown_here_comes_the_pain/favicon.png\",\"width\":32,\"height\":32},\"trophy-1st\":{\"uri\":\"https://www.speedrun.com/themes/Default/1st.png\",\"width\":64,\"height\":64},\"trophy-2nd\":{\"uri\":\"https://www.speedrun.com/themes/Default/2nd.png\",\"width\":64,\"height\":64},\"trophy-3rd\":{\"uri\":\"https://www.speedrun.com/themes/Default/3rd.png\",\"width\":64,\"height\":64},\"trophy-4th\":null,\"background\":null,\"foreground\":null},\"links\":[{\"rel\":\"self\",\"uri\":\"https://www.speedrun.com/api/v1/games/j1n4296p\"},{\"rel\":\"runs\",\"uri\":\"https://www.speedrun.com/api/v1/runs?game=j1n4296p\"},{\"rel\":\"levels\",\"uri\":\"https://www.speedrun.com/api/v1/games/j1n4296p/levels\"},{\"rel\":\"categories\",\"uri\":\"https://www.speedrun.com/api/v1/games/j1n4296p/categories\"},{\"rel\":\"variables\",\"uri\":\"https://www.speedrun.com/api/v1/games/j1n4296p/variables\"},{\"rel\":\"records\",\"uri\":\"https://www.speedrun.com/api/v1/games/j1n4296p/records\"},{\"rel\":\"series\",\"uri\":\"https://www.speedrun.com/api/v1/series/wnp18znm\"},{\"rel\":\"derived-games\",\"uri\":\"https://www.speedrun.com/api/v1/games/j1n4296p/derived-games\"},{\"rel\":\"romhacks\",\"uri\":\"https://www.speedrun.com/api/v1/games/j1n4296p/derived-games\"},{\"rel\":\"leaderboard\",\"uri\":\"https://www.speedrun.com/api/v1/leaderboards/j1n4296p/category/7dg11xd4\"}]}";
    String game6 = "{\"id\":\"9d3yzw6l\",\"names\":{\"international\":\"(The) Final Fantasy Legend\",\"japanese\":\"魔界塔士 Sa・Ga\",\"twitch\":\"The Final Fantasy Legend\"},\"abbreviation\":\"The_Final_Fantasy_Legend\",\"weblink\":\"https://www.speedrun.com/The_Final_Fantasy_Legend\",\"released\":1990,\"release-date\":\"1990-09-30\",\"ruleset\":{\"show-milliseconds\":false,\"require-verification\":true,\"require-video\":true,\"run-times\":[\"realtime\"],\"default-time\":\"realtime\",\"emulators-allowed\":true},\"romhack\":false,\"gametypes\":[],\"platforms\":[\"3167jd6q\",\"7m6yvw6p\",\"n5e147e2\",\"n5683oev\"],\"regions\":[\"pr184lqn\",\"e6lxy1dz\",\"o316x197\"],\"genres\":[],\"engines\":[],\"developers\":[],\"publishers\":[],\"moderators\":{\"zxz7q4jq\":\"super-moderator\",\"qjo3vllj\":\"super-moderator\"},\"created\":\"2016-01-01T01:48:08Z\",\"assets\":{\"logo\":{\"uri\":\"https://www.speedrun.com/themes/Default/logo.png\",\"width\":640,\"height\":78},\"cover-tiny\":{\"uri\":\"https://www.speedrun.com/themes/The_Final_Fantasy_Legend/cover-32.png\",\"width\":32,\"height\":32},\"cover-small\":{\"uri\":\"https://www.speedrun.com/themes/The_Final_Fantasy_Legend/cover-64.png\",\"width\":64,\"height\":64},\"cover-medium\":{\"uri\":\"https://www.speedrun.com/themes/The_Final_Fantasy_Legend/cover-128.png\",\"width\":128,\"height\":128},\"cover-large\":{\"uri\":\"https://www.speedrun.com/themes/The_Final_Fantasy_Legend/cover-256.png\",\"width\":256,\"height\":256},\"icon\":{\"uri\":\"https://www.speedrun.com/themes/Default/favicon.png\",\"width\":64,\"height\":64},\"trophy-1st\":{\"uri\":\"https://www.speedrun.com/themes/Default/1st.png\",\"width\":64,\"height\":64},\"trophy-2nd\":{\"uri\":\"https://www.speedrun.com/themes/Default/2nd.png\",\"width\":64,\"height\":64},\"trophy-3rd\":{\"uri\":\"https://www.speedrun.com/themes/Default/3rd.png\",\"width\":64,\"height\":64},\"trophy-4th\":null,\"background\":null,\"foreground\":null},\"links\":[{\"rel\":\"self\",\"uri\":\"https://www.speedrun.com/api/v1/games/9d3yzw6l\"},{\"rel\":\"runs\",\"uri\":\"https://www.speedrun.com/api/v1/runs?game=9d3yzw6l\"},{\"rel\":\"levels\",\"uri\":\"https://www.speedrun.com/api/v1/games/9d3yzw6l/levels\"},{\"rel\":\"categories\",\"uri\":\"https://www.speedrun.com/api/v1/games/9d3yzw6l/categories\"},{\"rel\":\"variables\",\"uri\":\"https://www.speedrun.com/api/v1/games/9d3yzw6l/variables\"},{\"rel\":\"records\",\"uri\":\"https://www.speedrun.com/api/v1/games/9d3yzw6l/records\"},{\"rel\":\"series\",\"uri\":\"https://www.speedrun.com/api/v1/series/8nwp6q7y\"},{\"rel\":\"derived-games\",\"uri\":\"https://www.speedrun.com/api/v1/games/9d3yzw6l/derived-games\"},{\"rel\":\"romhacks\",\"uri\":\"https://www.speedrun.com/api/v1/games/9d3yzw6l/derived-games\"},{\"rel\":\"leaderboard\",\"uri\":\"https://www.speedrun.com/api/v1/leaderboards/9d3yzw6l/category/9d8pz73k\"}]}";
    String game7 = "{\"id\":\"m1m8r3d2\",\"names\":{\"international\":\"..and the mooncats\",\"japanese\":null,\"twitch\":\"..and the mooncats\"},\"abbreviation\":\".and_the_mooncats\",\"weblink\":\"https://www.speedrun.com/.and_the_mooncats\",\"released\":2015,\"release-date\":\"2015-12-14\",\"ruleset\":{\"show-milliseconds\":false,\"require-verification\":true,\"require-video\":true,\"run-times\":[\"realtime\"],\"default-time\":\"realtime\",\"emulators-allowed\":true},\"romhack\":false,\"gametypes\":[],\"platforms\":[\"8gej2n93\"],\"regions\":[],\"genres\":[\"qdnqkn8k\",\"pm21l54x\"],\"engines\":[\"yw3vk1o0\"],\"developers\":[\"1zk9dpej\"],\"publishers\":[],\"moderators\":{\"48gr2orx\":\"super-moderator\",\"18vro05x\":\"moderator\"},\"created\":\"2017-05-07T01:17:27Z\",\"assets\":{\"logo\":{\"uri\":\"https://www.speedrun.com/themes/Default/logo.png\",\"width\":640,\"height\":78},\"cover-tiny\":{\"uri\":\"https://www.speedrun.com/themes/.and_the_mooncats/cover-32.png\",\"width\":45,\"height\":32},\"cover-small\":{\"uri\":\"https://www.speedrun.com/themes/.and_the_mooncats/cover-64.png\",\"width\":90,\"height\":64},\"cover-medium\":{\"uri\":\"https://www.speedrun.com/themes/.and_the_mooncats/cover-128.png\",\"width\":180,\"height\":128},\"cover-large\":{\"uri\":\"https://www.speedrun.com/themes/.and_the_mooncats/cover-256.png\",\"width\":360,\"height\":256},\"icon\":{\"uri\":\"https://www.speedrun.com/themes/Default/favicon.png\",\"width\":64,\"height\":64},\"trophy-1st\":{\"uri\":\"https://www.speedrun.com/themes/Default/1st.png\",\"width\":64,\"height\":64},\"trophy-2nd\":{\"uri\":\"https://www.speedrun.com/themes/Default/2nd.png\",\"width\":64,\"height\":64},\"trophy-3rd\":{\"uri\":\"https://www.speedrun.com/themes/Default/3rd.png\",\"width\":64,\"height\":64},\"trophy-4th\":null,\"background\":null,\"foreground\":null},\"links\":[{\"rel\":\"self\",\"uri\":\"https://www.speedrun.com/api/v1/games/m1m8r3d2\"},{\"rel\":\"runs\",\"uri\":\"https://www.speedrun.com/api/v1/runs?game=m1m8r3d2\"},{\"rel\":\"levels\",\"uri\":\"https://www.speedrun.com/api/v1/games/m1m8r3d2/levels\"},{\"rel\":\"categories\",\"uri\":\"https://www.speedrun.com/api/v1/games/m1m8r3d2/categories\"},{\"rel\":\"variables\",\"uri\":\"https://www.speedrun.com/api/v1/games/m1m8r3d2/variables\"},{\"rel\":\"records\",\"uri\":\"https://www.speedrun.com/api/v1/games/m1m8r3d2/records\"},{\"rel\":\"series\",\"uri\":\"https://www.speedrun.com/api/v1/series/yr4gon12\"},{\"rel\":\"derived-games\",\"uri\":\"https://www.speedrun.com/api/v1/games/m1m8r3d2/derived-games\"},{\"rel\":\"romhacks\",\"uri\":\"https://www.speedrun.com/api/v1/games/m1m8r3d2/derived-games\"},{\"rel\":\"leaderboard\",\"uri\":\"https://www.speedrun.com/api/v1/leaderboards/m1m8r3d2/category/zdnrnvq2\"}]}";
    String game8 = "{\"id\":\"y65e0e6e\",\"names\":{\"international\":\".flow\",\"japanese\":null,\"twitch\":\"Yume Nikki\"},\"abbreviation\":\".flow\",\"weblink\":\"https://www.speedrun.com/.flow\",\"released\":2009,\"release-date\":\"2009-02-15\",\"ruleset\":{\"show-milliseconds\":false,\"require-verification\":true,\"require-video\":true,\"run-times\":[\"realtime\"],\"default-time\":\"realtime\",\"emulators-allowed\":true},\"romhack\":false,\"gametypes\":[],\"platforms\":[\"8gej2n93\"],\"regions\":[\"o316x197\"],\"genres\":[\"oy5ggp5e\",\"oy5gp5e3\"],\"engines\":[\"0k1n6k5o\"],\"developers\":[\"ge080nzp\"],\"publishers\":[\"9neqjjn5\",\"kr235y6e\"],\"moderators\":{\"98rpv5wj\":\"moderator\",\"o86nvd3x\":\"super-moderator\"},\"created\":\"2016-03-12T15:42:32Z\",\"assets\":{\"logo\":{\"uri\":\"https://www.speedrun.com/themes/Default/logo.png\",\"width\":640,\"height\":78},\"cover-tiny\":{\"uri\":\"https://www.speedrun.com/themes/.flow/cover-32.png\",\"width\":32,\"height\":32},\"cover-small\":{\"uri\":\"https://www.speedrun.com/themes/.flow/cover-64.png\",\"width\":64,\"height\":64},\"cover-medium\":{\"uri\":\"https://www.speedrun.com/themes/.flow/cover-128.png\",\"width\":128,\"height\":128},\"cover-large\":{\"uri\":\"https://www.speedrun.com/themes/.flow/cover-256.png\",\"width\":256,\"height\":256},\"icon\":{\"uri\":\"https://www.speedrun.com/themes/.flow/favicon.png\",\"width\":16,\"height\":16},\"trophy-1st\":{\"uri\":\"https://www.speedrun.com/themes/Default/1st.png\",\"width\":64,\"height\":64},\"trophy-2nd\":{\"uri\":\"https://www.speedrun.com/themes/Default/2nd.png\",\"width\":64,\"height\":64},\"trophy-3rd\":{\"uri\":\"https://www.speedrun.com/themes/Default/3rd.png\",\"width\":64,\"height\":64},\"trophy-4th\":null,\"background\":{\"uri\":\"https://www.speedrun.com/themes/.flow/background.png\",\"width\":2400,\"height\":2080},\"foreground\":null},\"links\":[{\"rel\":\"self\",\"uri\":\"https://www.speedrun.com/api/v1/games/y65e0e6e\"},{\"rel\":\"runs\",\"uri\":\"https://www.speedrun.com/api/v1/runs?game=y65e0e6e\"},{\"rel\":\"levels\",\"uri\":\"https://www.speedrun.com/api/v1/games/y65e0e6e/levels\"},{\"rel\":\"categories\",\"uri\":\"https://www.speedrun.com/api/v1/games/y65e0e6e/categories\"},{\"rel\":\"variables\",\"uri\":\"https://www.speedrun.com/api/v1/games/y65e0e6e/variables\"},{\"rel\":\"records\",\"uri\":\"https://www.speedrun.com/api/v1/games/y65e0e6e/records\"},{\"rel\":\"series\",\"uri\":\"https://www.speedrun.com/api/v1/series/yr4gon12\"},{\"rel\":\"derived-games\",\"uri\":\"https://www.speedrun.com/api/v1/games/y65e0e6e/derived-games\"},{\"rel\":\"romhacks\",\"uri\":\"https://www.speedrun.com/api/v1/games/y65e0e6e/derived-games\"},{\"rel\":\"leaderboard\",\"uri\":\"https://www.speedrun.com/api/v1/leaderboards/y65e0e6e/category/7dg8qnp2\"}]}";
    String game9 = "{\"id\":\"nd2ekj5d\",\"names\":{\"international\":\".hack//G.U. Last Recode\",\"japanese\":null,\"twitch\":\".hack//G.U. Last Recode\"},\"abbreviation\":\"guhd\",\"weblink\":\"https://www.speedrun.com/guhd\",\"released\":2017,\"release-date\":\"2017-11-01\",\"ruleset\":{\"show-milliseconds\":false,\"require-verification\":true,\"require-video\":true,\"run-times\":[\"realtime\"],\"default-time\":\"realtime\",\"emulators-allowed\":false},\"romhack\":false,\"gametypes\":[],\"platforms\":[\"nzelkr6q\",\"8gej2n93\"],\"regions\":[\"pr184lqn\",\"e6lxy1dz\",\"o316x197\"],\"genres\":[\"94n4pn0w\",\"9rnv49nq\"],\"engines\":[],\"developers\":[\"1zkl9pej\"],\"publishers\":[\"5p6z7yr3\"],\"moderators\":{\"qjoee786\":\"super-moderator\",\"48ge6kyj\":\"super-moderator\",\"5j5gd2q8\":\"moderator\"},\"created\":\"2017-11-05T10:37:14Z\",\"assets\":{\"logo\":{\"uri\":\"https://www.speedrun.com/themes/Default/logo.png\",\"width\":640,\"height\":78},\"cover-tiny\":{\"uri\":\"https://www.speedrun.com/themes/guhd/cover-32.png\",\"width\":32,\"height\":41},\"cover-small\":{\"uri\":\"https://www.speedrun.com/themes/guhd/cover-64.png\",\"width\":64,\"height\":82},\"cover-medium\":{\"uri\":\"https://www.speedrun.com/themes/guhd/cover-128.png\",\"width\":128,\"height\":164},\"cover-large\":{\"uri\":\"https://www.speedrun.com/themes/guhd/cover-256.png\",\"width\":256,\"height\":328},\"icon\":{\"uri\":\"https://www.speedrun.com/themes/Default/favicon.png\",\"width\":64,\"height\":64},\"trophy-1st\":{\"uri\":\"https://www.speedrun.com/themes/Default/1st.png\",\"width\":64,\"height\":64},\"trophy-2nd\":{\"uri\":\"https://www.speedrun.com/themes/Default/2nd.png\",\"width\":64,\"height\":64},\"trophy-3rd\":{\"uri\":\"https://www.speedrun.com/themes/Default/3rd.png\",\"width\":64,\"height\":64},\"trophy-4th\":null,\"background\":{\"uri\":\"https://www.speedrun.com/themes/guhd/background.png\",\"width\":1680,\"height\":1050},\"foreground\":null},\"links\":[{\"rel\":\"self\",\"uri\":\"https://www.speedrun.com/api/v1/games/nd2ekj5d\"},{\"rel\":\"runs\",\"uri\":\"https://www.speedrun.com/api/v1/runs?game=nd2ekj5d\"},{\"rel\":\"levels\",\"uri\":\"https://www.speedrun.com/api/v1/games/nd2ekj5d/levels\"},{\"rel\":\"categories\",\"uri\":\"https://www.speedrun.com/api/v1/games/nd2ekj5d/categories\"},{\"rel\":\"variables\",\"uri\":\"https://www.speedrun.com/api/v1/games/nd2ekj5d/variables\"},{\"rel\":\"records\",\"uri\":\"https://www.speedrun.com/api/v1/games/nd2ekj5d/records\"},{\"rel\":\"series\",\"uri\":\"https://www.speedrun.com/api/v1/series/8nwjpj7y\"},{\"rel\":\"derived-games\",\"uri\":\"https://www.speedrun.com/api/v1/games/nd2ekj5d/derived-games\"},{\"rel\":\"romhacks\",\"uri\":\"https://www.speedrun.com/api/v1/games/nd2ekj5d/derived-games\"},{\"rel\":\"leaderboard\",\"uri\":\"https://www.speedrun.com/api/v1/leaderboards/nd2ekj5d/category/9d866g62\"}]}";
    String game10 = "{\"id\":\"pd0y226e\",\"names\":{\"international\":\".hack//G.U. Volume 1: Rebirth\",\"japanese\":null,\"twitch\":\".hack//G.U. Volume 1: Rebirth\"},\"abbreviation\":\".hack_g.u._volume_1_rebirth\",\"weblink\":\"https://www.speedrun.com/.hack_g.u._volume_1_rebirth\",\"released\":2006,\"release-date\":\"2006-06-20\",\"ruleset\":{\"show-milliseconds\":false,\"require-verification\":true,\"require-video\":true,\"run-times\":[\"realtime\"],\"default-time\":\"realtime\",\"emulators-allowed\":true},\"romhack\":false,\"gametypes\":[],\"platforms\":[\"n5e17e27\"],\"regions\":[\"pr184lqn\",\"o316x197\"],\"genres\":[\"94n4pn0w\",\"9rnv49nq\"],\"engines\":[],\"developers\":[\"1zkl9pej\"],\"publishers\":[\"5p6z7yr3\"],\"moderators\":{\"68we7q8g\":\"moderator\",\"qjoee786\":\"moderator\",\"48ge6kyj\":\"super-moderator\"},\"created\":\"2015-11-19T09:23:59Z\",\"assets\":{\"logo\":{\"uri\":\"https://www.speedrun.com/themes/Default/logo.png\",\"width\":640,\"height\":78},\"cover-tiny\":{\"uri\":\"https://www.speedrun.com/themes/.hack_g.u._volume_1_rebirth/cover-32.png\",\"width\":32,\"height\":45},\"cover-small\":{\"uri\":\"https://www.speedrun.com/themes/.hack_g.u._volume_1_rebirth/cover-64.png\",\"width\":64,\"height\":90},\"cover-medium\":{\"uri\":\"https://www.speedrun.com/themes/.hack_g.u._volume_1_rebirth/cover-128.png\",\"width\":128,\"height\":180},\"cover-large\":{\"uri\":\"https://www.speedrun.com/themes/.hack_g.u._volume_1_rebirth/cover-256.png\",\"width\":256,\"height\":360},\"icon\":{\"uri\":\"https://www.speedrun.com/themes/Default/favicon.png\",\"width\":64,\"height\":64},\"trophy-1st\":{\"uri\":\"https://www.speedrun.com/themes/Default/1st.png\",\"width\":64,\"height\":64},\"trophy-2nd\":{\"uri\":\"https://www.speedrun.com/themes/Default/2nd.png\",\"width\":64,\"height\":64},\"trophy-3rd\":{\"uri\":\"https://www.speedrun.com/themes/Default/3rd.png\",\"width\":64,\"height\":64},\"trophy-4th\":null,\"background\":{\"uri\":\"https://www.speedrun.com/themes/.hack_g.u._volume_1_rebirth/background.png\",\"width\":1680,\"height\":1050},\"foreground\":null},\"links\":[{\"rel\":\"self\",\"uri\":\"https://www.speedrun.com/api/v1/games/pd0y226e\"},{\"rel\":\"runs\",\"uri\":\"https://www.speedrun.com/api/v1/runs?game=pd0y226e\"},{\"rel\":\"levels\",\"uri\":\"https://www.speedrun.com/api/v1/games/pd0y226e/levels\"},{\"rel\":\"categories\",\"uri\":\"https://www.speedrun.com/api/v1/games/pd0y226e/categories\"},{\"rel\":\"variables\",\"uri\":\"https://www.speedrun.com/api/v1/games/pd0y226e/variables\"},{\"rel\":\"records\",\"uri\":\"https://www.speedrun.com/api/v1/games/pd0y226e/records\"},{\"rel\":\"series\",\"uri\":\"https://www.speedrun.com/api/v1/series/8nwjpj7y\"},{\"rel\":\"derived-games\",\"uri\":\"https://www.speedrun.com/api/v1/games/pd0y226e/derived-games\"},{\"rel\":\"romhacks\",\"uri\":\"https://www.speedrun.com/api/v1/games/pd0y226e/derived-games\"},{\"rel\":\"leaderboard\",\"uri\":\"https://www.speedrun.com/api/v1/leaderboards/pd0y226e/category/jdrqw4gk\"}]}";

    @Test
    public void fromApi() {

        Gson gson = new Gson();

        ArrayList<oriolvillaret.com.api_connection_lib.models.Game> apiElems = new ArrayList<>();
        apiElems.add(gson.fromJson(game1, oriolvillaret.com.api_connection_lib.models.Game.class));
        apiElems.add(gson.fromJson(game2, oriolvillaret.com.api_connection_lib.models.Game.class));
        apiElems.add(gson.fromJson(game3, oriolvillaret.com.api_connection_lib.models.Game.class));
        apiElems.add(gson.fromJson(game4, oriolvillaret.com.api_connection_lib.models.Game.class));
        apiElems.add(gson.fromJson(game5, oriolvillaret.com.api_connection_lib.models.Game.class));
        apiElems.add(gson.fromJson(game6, oriolvillaret.com.api_connection_lib.models.Game.class));
        apiElems.add(gson.fromJson(game7, oriolvillaret.com.api_connection_lib.models.Game.class));
        apiElems.add(gson.fromJson(game8, oriolvillaret.com.api_connection_lib.models.Game.class));
        apiElems.add(gson.fromJson(game9, oriolvillaret.com.api_connection_lib.models.Game.class));
        apiElems.add(gson.fromJson(game10, oriolvillaret.com.api_connection_lib.models.Game.class));

        ArrayList<Game> appElems = GameMapper.fromApi(apiElems);

        assertEquals(appElems.size(), apiElems.size());

        //order is important
        for (int x = 0; x<apiElems.size(); x++){

            oriolvillaret.com.api_connection_lib.models.Game gameApi = apiElems.get(x);
            Game gameApp = appElems.get(x);
            assertEquals(gameApp.getId(), gameApi.id);
            assertEquals(gameApp.getLogoURL(), gameApi.assets.icon.uri);
            assertEquals(gameApp.getName(), gameApi.names.international);
        }
    }

}