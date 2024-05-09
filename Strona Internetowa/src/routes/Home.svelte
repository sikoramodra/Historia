<script>
  import { onMount } from "svelte";
  import { writable } from 'svelte/store';
  import Footer from '../lib/sections/Footer.svelte';
  import Navbar from '../lib/sections/Navbar.svelte';
  import { mainColorBorder, mainColorText } from '../stores/ColorStore.js';

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
  

  <div class="parallax-item">
    <column>
      <h1 class="napis1">Coś tam że cudowna historia</h1>
      <p>genialnie ustawiane opony w samochodzie to podstawa dobrego auta, nie wiadomo co może powodować takiego spokoju nie można napierwszy rzut oka oceniać</p>
    </column>
    <divider class="divider"></divider>
    <divider class="divider1"></divider>
    <obrazek class="obrazek"></obrazek>
  </div>
  <div class="parallax-item"></div>
  <Footer/>
</section>

</html>

<style>
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
    position: absolute;
    height: 80vh;
    background-color: white;
    width: 1px;
    float: left;
    margin-top: 10vh;
    margin-bottom: 10vh;
    margin-left: 49%;
    margin-right: 51%;
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
    position: absolute;
    height: 80vh;
    background-color: red;
    width: 1px;
    float: left;
    margin-top: 10vh;
    margin-bottom: 10vh;
    margin-left: 51%;
    margin-right: 49%;
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
    color: #333;
    font-size: 32px;
  }
  .parallax-item p {
    color: #666;
    font-size: 18px;
    line-height: 1.6;
    margin-top: 20px;
    text-align: left;
  }

  .napis {
    margin-left: 15%;
    margin-right: 50%;
    
  }
  .obrazek {
    background: url("../res/FPWP.gif");
    min-width: 100px;
    height: 100px;
    background-size: cover;
    float: right;
    margin-right: 20%;
    margin-left: 50%;
    margin-top: 20%;
    zoom: 3;
    align-items: center;
  }
  .parallax-item {
    display: flex;
    font-weight: bold;
    font-family: Montserrat, sans-serif;
    width: 100%;
    min-height: 100vh;
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
    background: #05051b;
    z-index: 11;
    position:relative;
  }
  .parallax-item:nth-child(3) {
    background: url("../res/film.gif");
    background-size: cover;
    background-position: center;
    background-attachment: fixed;
    min-height: 600px;
  }
  .parallax-item:nth-child(4) {
    background: #1565c0;
  }
  @media screen and (max-width: 768px) {
    .parallax-item h2 {
      font-size: 1.5rem;
    }
  }
  h1::after {
    display: block;
    content: "";
    width: 8rem;
    height: 1px;
    background-color: #8dc63f;
    left: 0;
    bottom: 0;
    font-size: 3rem;
    color: white;
  }
  h1 {
    font-family: "DM Serif Display", serif;
    font-weight: 400;
    padding-bottom: 3.6rem;
    margin-bottom: 3.6rem;
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
  }
</style>

<Navbar/>
