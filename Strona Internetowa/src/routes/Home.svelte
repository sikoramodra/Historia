<script>
  import { onMount } from "svelte";
  import { writable } from 'svelte/store';
  import Footer from '../lib/sections/Footer.svelte';
  import Navbar from '../lib/sections/Navbar.svelte';
  import { mainColorBorder, mainColorText } from '../stores/ColorStore.js';
  import { isDarkMode, currentChartMode, appColors, chartBGColors } from '../lib/sections/stores';
  import NotAChart from '../lib/sections/NotAChart.svelte';
	
  mainColorText.set("text-white");
  mainColorBorder.set("border-white");

  let textToAnimate = writable('');
  let index = 0;
  let speed = 70; // Adjust the speed of typing animation here

  // Text to animate
  const text = "Jesteśmy by Pamiętać";
  
  onMount(() => {
      const type = () => {
          if (index < text.length) {
              const currentChar = text.charAt(index);
              if (currentChar === ' ') {
                  textToAnimate.update(oldValue => oldValue + ' '); // Append space without removing it
              } else {
                  textToAnimate.update(oldValue => oldValue + currentChar);
              }
              index++;
              setTimeout(type, speed);
          } else {
              // Parallax Effect for DIV 1
              const parallax = document.getElementById("parallax");
              window.addEventListener("scroll", function () {
                  let offset = window.pageYOffset;
                  parallax.style.backgroundPositionY = offset * 0.7 + "px";
                  // DIV 1 background will move slower than other elements on scroll.
              });
          }
      };
      type();
  });

  onMount(() => {
      // Scroll Down Button
      const scrollDownButton = document.getElementById("scroll-down");
      if (scrollDownButton) {
          scrollDownButton.addEventListener('click', () => {
              window.scroll({
                  top: window.innerHeight,
                  behavior: 'smooth'
              });
          });
      };
  });
</script>

<html lang="en">
<head>
  <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Montserrat:400,700">
</head>

<section id="section">
  <div id="parallax" class="parallax-item">
    <section class="s-intro s-intro--static">
    <div class="grid-overlay">
      <div></div>
    </div>
    <div class="intro-content row">
      <div class="column">
        <div class="header-email">
          <a href="mailto:biuro@fundacjapileckiego.pl">biuro@fundacjapileckiego.pl</a>
        </div>
        <h2 class="napis">Fundacja Patriotyczna <br>im. Witolda Pileckiego<br></h2>
        <div class="intro-content--text">
        <h3>(KRS: 0000874120)</h3></div>
      </div>
    </div></section>
  </div>
  

  <div class="parallax-item bg-gradient-to-b from-slate-950 to-slate-800 content-center">
<div class="divider"></div>
<div class="divider1"></div>  
    <column>
      <h1 class="napis1">Fundacja Patriotyczna im. Witolda Pileckiego</h1>
      <p class="lead">
        Fundacja Patriotyczna im. Witolda Pileckiego (KRS: 0000874120) to organizacja mająca na celu kształtowanie postaw patriotycznych oraz m.in. propagowanie idei i zasad jakich w swoim życiu kierował się patron Fundacji - Rotmistrz Witold Pilecki.
      </p>
      <p>Systematycznie będziemy przedstawiali inicjatywy i obszary funkcjonowania naszej Fundacji. Zanim jednak do tego przejdziemy chcielibyśmy przybliżyć postać naszego Patrona, do którego będziemy w naszej działalności wielokrotnie wracać. Kim był Witold Pilecki?</p>
      <p>Rotmistrz Witold Pilecki (1901 - 1948) był harcerzem, społecznikiem, artystą i ziemianinem, żołnierzem, oficerem Wojska Polskiego, uczestnikiem konspiracji i walk o niepodległość Rzeczypospolitej, m.in. był uczestnikiem wojny polsko-bolszewickiej 1920 r., patriotą.</p>
      <p>Od chwili wybuchu II wojny światowej czynnie uczestniczył w obronie Polski. Od listopada 1939 r. w podziemiu niepodległościowym - współtworzył Tajną Armię Polską.</p>
      <p>W latach 1940-1943 był dobrowolnym więźniem niemieckiego obozu koncentracyjnego - KL Auschwitz, gdzie m.in. założył organizację podziemną, a także dokumentował niemieckie zbrodnie i dramat bestialsko traktowanych więźniów. Po wypełnieniu misji i ucieczce z KL Auschwitz, powrócił do walki zbrojnej.</p>
      <p>Uczestnik Powstania Warszawskiego, walczący w Zgrupowaniu "Chrobry II" oraz Kompanii "Warszawianka", jeniec obozów w Lamsdorf i Murnau, a następnie żołnierz Polskich Sił Zbrojnych na Zachodzie w II Korpusie Polskim gen. Władysława Andersa.</p>
      <p>Po powrocie do zniewolonej przez sowietów Polski, zaangażował się w działalność antykomunistyczną i niepodległościową. Aresztowany przez komunistów, poddany brutalnemu śledztwu, po sfingowanym procesie został skazany na śmierć i zamordowany 25 maja 1948 r. w w więzieniu mokotowskim w Warszawie. Miejsce spoczynku Rotmistrza Witolda Pileckiego nie jest do tej pory znane...</p>
    </column>
    <div class="divider"></div>
   <div class="divider1"></div> 
  </div>
  
  <div class="parallax-item">
    <div class="row tab-content--item-header content-center">
      <div class="column">
        <h1 class="nasze">Nasze działania:</h1>
        <p class="p">
          Jedną z inicjatyw jaką udało nam się zrealizować w 2021 r., to zakup lokalu dla działań Fundacji Patriotycznej im. Witolda Pileckiego, głównie dla działań prowadzonych przez Centrum Wolontariatu Patriotycznego "Szaniec" oraz Instytutu Ziem Zachodnich im. Lecha Karola Neymana. Zakup lokalu dofinansowano ze środków budżetu państwa w ramach Funduszu Patriotycznego.
        </p>
      </div>
    </div>
  </div>
  <Footer/>
  
</section>

</html>

<style>

  .p{
    font-size: 40rem;
    
  }
  .nasze{
    color:white;
    font-size:3rem;
    margin-left: auto;
    margin-right: auto;
    
  }
  column {
    width:80%;
    margin-top: auto;
    margin-bottom: auto;
    margin-left: auto;
    margin-right: auto;
  }
  .column {
    width:80%;
    margin-top: auto;
    margin-bottom: auto;
    margin-left: auto;
    margin-right: auto;
  }
  @media screen and (max-width: 600px) {
    .intro-content--text h3 {
        font-size: 1.2rem;
    }
}
  .intro-content--text h3 {
    display: inline-block;
    font-family: "Gothic A1", sans-serif;
    font-weight: 400;
    font-size: 1.4rem;
    line-height: 2rem;
    text-transform: uppercase;
    letter-spacing: .3em;
    color: #8dc63f;
    padding-left: .6rem;
    margin-top: 0;
    margin-bottom: .8rem;
    position: relative;
    font-variant-ligatures: common-ligatures;
    text-rendering: optimizeLegibility;
    margin-left:15%;
}
  @media screen and (max-width: 1600px) {
    .grid-overlay::after {
        right: 22.5%;
    }
  }
  .grid-overlay > div {
    left: 50%;
  }
  .s-intro--static::after {
    display: block;
    content: "";
    position: absolute;
    top: 0;
    left: 0;
    width: 100%;
    height: 100%;
    background: linear-gradient(270deg, rgba(0, 0, 0, 0) 0%, black 100%);
    opacity: .6;
}
  .grid-overlay {
    z-index: 1;
    display: block;
    width: 89%;
    height: 200%;
    opacity: .65;
    border-right: 1px solid rgb(255, 255, 255);
    border-left: 1px solid rgba(255, 255, 255, 0.1);
    transform: translate3d(-50%, 0, 0);
    position: absolute;
    top: 0;
    right: 0;
    bottom: 0;
    left: 50%;
  }
  @media screen and (max-width: 1600px) {
    .grid-overlay {
        border-right: none !important;
        border-left: none !important;
    }
  }
  .intro-content {
    z-index: 2;
    height: 100%;
    padding-top: 20vh;
    padding-bottom: 24rem;
    align-items: center;
    position: relative;
  }
  @media screen and (max-width: 1100px) {
    .header-email {
        left: 4rem;
    }
  }
  .header-email {
    font-size: 1.5rem;
    line-height: 3.2rem;
    transform: translate3d(0, -50%, 0);
    position: absolute;
    top: 75%;
    left: 8rem;
  }
  .grid-overlay > div, .grid-overlay::before, .grid-overlay::after {
    background-color: rgba(255, 255, 255, 0.137);
    height: 100%;
    width: 2px;
    position: absolute;
    top: 0;
    bottom: 0;
  }
  @media screen and (max-width: 1600px) {
    .grid-overlay::before {
        left: 25.5%;
    }
  }
  .grid-overlay::before {
    content: "";
    left: 30%;
  }
  .divider {
    margin-left: auto;
    min-height: 80vh;
    background-color: white;
    width: 1px;
    float: left;
 
  }
  .s-intro--static::after {
    display: block;
    content: "";
    position: absolute;
    top: 0;
    left: 0;
    width: 100%;
    height: 200%;
    background: linear-gradient(270deg, rgba(0, 0, 0, 0) 0%, black 100%);
    opacity: .6;
}
  .divider1 {
    margin-right: auto;
    min-height: 90vh;
    background-color: red;
    width: 1px; 
    margin-left: 3px;
    float: left;
 
  }
  * {
    padding: 0;
    margin: 0;
    user-select: none;
    zoom: 100%;
  }
  html {
    scroll-behavior: smooth;
  }
  .header-email a {
    color: rgba(255, 255, 255, 0.4);
    display: inline-block;
    position: relative;
  }
  a {
    color: #8dc63f;
    transition: all 0.3s cubic-bezier(0.23, 1, 0.32, 1);
    text-decoration: none;
  }
  a {
    text-decoration: none;
    line-height: inherit;
  }
  .napis1 {
    color: white;
    font-size:4rem;
    padding:0;
    margin-bottom: 1%;
    margin-left: 10px;
    margin-top: 1%;
  }
  .parallax-item p {
    
    font-size: 20px;
    line-height: 1.6;
    margin-top: 20px;
    text-align: left;
  }

  .napis {
    margin-left: 15%;
    margin-right: 50%;
    
  }

  .parallax-item {
    display: flex;
    font-weight: bold;
    font-family: Montserrat, sans-serif;
    width: 100%;
   
  }
  .parallax-item h2 {
    font-size: 3rem;
    text-transform: uppercase;
    color: white;
    padding: 1rem;
    border-radius: 1rem;
  }
  .parallax-item:first-child {
    background-repeat: no-repeat;
    background: url("../res/bg-static.jpg");
    background-size: cover;
    background-position: center center;
  }
  .parallax-item:first-child h2::before {
    content: '';
    position: absolute;
    top: 0;
    left: 0;
    right: 0;
    bottom: 0;
    background: linear-gradient(270deg, rgba(0, 0, 0, 0) 0%, black 100%);
    z-index: -1;
  }
  .parallax-item:nth-child(2) {
    z-index: 11;
    position:relative;
    min-height: 400px;
    color:white;
  }
  .parallax-item:nth-child(3) {
    background: linear-gradient(rgba(0, 0, 0, 0.8), rgba(0, 0, 0, 0.8)),
    url("../res/defiladapolski.png");
    background-size: cover;
    background-position: center;
    background-attachment: fixed;
    min-height: 700px;
    color:white;
    align-content: center;
  }
 
  @media screen and (max-width: 768px) {
    .parallax-item h2 {
      font-size: 1.5rem;
    }
  }
  h1::after {
    display: block;
    content: "";
    max-width: 77rem;
    height: 1px;
    background-color: #8dc63f;
    left: 0;
    bottom: 0;
    font-size: 1rem;
    color: white;
  }
  h1 {
    font-family: "DM Serif Display", serif;
    font-weight: 400;
    text-align: center;
    position: relative;
  }
  p {
    display: block;
    margin-block-start: 1em;
    margin-block-end: 1em;
    margin-inline-start: 0px;
    margin-inline-end: 0px;
    unicode-bidi: isolate;
    text-rendering: optimizeLegibility;
    font-size:3px;
    margin-left: 10px;
  }
  @media screen and (max-width: 1000px) {
    column {
        zoom: 80%;
    }
}
@media screen and (max-width: 1500px) {
    column {
        zoom: 80%;
    }
}
@media screen and (max-width: 600px) {
    column {
        zoom: 60%;
    }
}


</style>

<Navbar/>
