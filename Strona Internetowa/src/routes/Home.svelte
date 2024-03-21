<script>
    import { slide } from 'svelte/transition';
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
                  textToAnimate.update(oldValue => oldValue + currentChar); // Append space without removing it
                } else {
                  textToAnimate.update(oldValue => oldValue + currentChar);
                }
                index++;
                setTimeout(type, speed);
            }
          };
        type(); 
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
      <h2 id="unique-heading">{ $textToAnimate }</h2>
    </div>
    <div class="parallax-item">
      <div class="text">
        <p>Tutaj umieść swój tekst</p>
    </div>
    <img src="obraz1.jpg" alt="Obraz 1">
    <img src="obraz2.jpg" alt="Obraz 2">
    </div>
    <div class="parallax-item">
      <h2>Wzium</h2>
    </div>
    <div class="parallax-item">
      <h2>Footer po tym</h2>
    </div>
  </section>
</html>

<style>
* {
  padding: 0;
  margin: 0;
}

html {
  scroll-behavior: smooth;
  
}

.parallax-item {
  display: flex;
  align-items: center;
  justify-content: center;
  font-weight: bold;
  font-family: Montserrat, sans-serif;
  width: 100%;
  min-height: 100vh;
}

#unique-heading {
  color:whitesmoke;
  font-size:100px;
  margin-left: 15vh;
  margin-right: 85vh;
  margin-top: 40vh;
  margin-bottom:60vh;
  display:inline-block;
  position:absolute;
}

.parallax-item:first-child {
  background: url("./defiladapolski.png") no-repeat center center;
  background-size:cover;
  backdrop-filter: brightness(20%);
  position: relative; /* Ustawienie pozycji względnej, aby umożliwić pozycjonowanie pseudo-elementu */
  
}

.parallax-item:first-child::before {
  content: '';
  position: absolute;
  top: 0;
  left: 0;
  right: 0;
  bottom: 0;
  background-color: rgba(0, 0, 0, 0.61); /* Przezroczyste tło */
  z-index: -1; }

  .parallax-item:nth-child(2) {
    display: flex;
    flex-direction: row-reverse; /* Odwróć kierunek flexboxa, aby zdjęcia znalazły się po prawej stronie */
    align-items: center; /* Wyrównaj elementy w pionie */
    background:#02021b;
}

.parallax-item:nth-child(2) .text {
    flex: 1; /* Rozszerz tekst na całą dostępną przestrzeń */
    padding: 20px; /* Dodaj trochę marginesu dla estetyki */
}

.parallax-item:nth-child(2) img {
    max-width: 50%; /* Ogranicz szerokość zdjęć do 50% szerokości kontenera */
    float: right; /* Zdjęcia będą wyrównane do prawej strony */
    margin-left: 20px; /* Dodaj odstęp między tekstem a zdjęciami */
}
.parallax-item:nth-child(3) {
  background: url("./gittest2.gif");
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
    font-size: 1vh;
  }
}

.parallax-item h2 {
  font-size: 3rem;
 
}
</style>
<button id="scroll-down">Scroll Down</button>
<Navbar/>


