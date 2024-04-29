<script>
  import { onMount } from "svelte";
  import { writable } from 'svelte/store';
  import Footer from '../lib/sections/Footer.svelte';
  import Navbar from '../lib/sections/Navbar.svelte';
  import { mainColorBorder, mainColorText } from '../stores/ColorStore.js';
//import Scrollbar from 'smooth-scrollbar'


/* import Attribution from './components/Attribution.svelte'
import Hero from './containers/Hero.svelte'
import Divider from './components/Divider.svelte'
import Feature from './containers/Feature.svelte'


import { initAnimations } from './scripts/animations'
*/

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
          }type();
        };
        const parallax = document.getElementById("parallax");

// Parallax Effect for DIV 1
window.addEventListener("scroll", function () {
let offset = window.pageYOffset;
parallax.style.backgroundPositionY = offset * 0.7 + "px";
// DIV 1 background will move slower than other elements on scroll.
});

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
// DIV 1 background will move slower than other elements on scroll.
</script>
<html lang="en">
<head>
  <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Montserrat:400,700">
</head>

<section id="section">
  <div id="parallax" class="parallax-item">
    <h2 class="napis">Jesteśmy by Pamiętać</h2>
  </div>
  <div class="parallax-item">
    <h2 class="napis1">Coś tam że cudowna historia
    <div class="tekst">genialnie ustawiane opony w samochodzie to podstawa dobrego auta, nie wiadomo co może powodować takiego spokoju nie można napierwszy rzut oka oceniać</div>
    </h2><divider class="divider"></divider>
    <divider class="divider1"></divider>
    <obrazek class="obrazek"></obrazek>
  </div>
  <div class="parallax-item">
    
  </div>

  <Footer/>
 
</section>


</html>

<style>
.divider{
  position: absolute;
    height:80vh;
    background-color:white;
    width:1px;
    float:left;
    margin-top:10vh;
    margin-bottom:10vh;
    margin-left:49%;
    margin-right: 51%;  }
  .divider1{
  position: absolute;
    height:80vh;
    background-color:red;
    width:1px;
    float:left;
    margin-top:10vh;
    margin-bottom:10vh;
    margin-left:51%;
    margin-right: 49%;  }
* {
padding: 0;
margin: 0;
user-select: none;
zoom: 100%;}

html {
scroll-behavior: smooth;

}
.napis1{
  margin-top:10% ;
  zoom:60%;
  float:left;
  margin-left: 5%;
}
.tekst{
  font-size:20px;
  color:blue;
}
.napis {
  margin-left: 7%;
  margin-right:55%;
  margin-top:20rem;
  }
  .obrazek{
    background: url("../res/FPWP.gif");
    min-width:100px;
    height:100px;
    background-size: cover;
    float:right;
    margin-right:20%;
    margin-left:50%;
    margin-top: 20%;
    zoom:3;
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
color:white;
padding: 1rem;
border-radius: 1rem;
}


.parallax-item:first-child {
background: url("../res/defiladapolski.png");
background-size: cover;
backdrop-filter: brightness(20%);
position: relative; /* Ustawienie pozycji względnej, aby umożliwić pozycjonowanie pseudo-elementu */
}

.parallax-item:first-child h2::before {
content: '';
position: absolute;
top: 0;
left: 0;
right: 0;
bottom: 0;
background-color: rgba(0, 0, 0, 0.61); /* Przezroczyste tło */
z-index: -1; }

.parallax-item:nth-child(2) {
background: #05051b;
}

.parallax-item:nth-child(3) {
background: url("../res/film.gif");
background-size: cover;
background-position: center;
background-attachment: fixed; /* Parallax Effect for DIV 3 */
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

</style>

<Navbar/>


