<script>
    import { onMount } from "svelte";
    import { writable } from 'svelte/store';

  //import Scrollbar from 'smooth-scrollbar'

  
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
      <h2 class="napis">Defilada Warszawskimi ulicami</h2>
    </div>
    <div class="parallax-item">
        <article>
            <h2>Pojęcie sztucznej inteligencji</h2>
            <p>Sztuczna inteligencja (SI) to obszar informatyki, który zajmuje się tworzeniem systemów i programów, które mogą wykonywać zadania wymagające inteligencji ludzkiej. W ostatnich latach SI stała się bardzo popularna i znalazła zastosowanie w wielu dziedzinach, takich jak medycyna, finanse, transport, czy handel.</p>
            <p>Technologie związane ze sztuczną inteligencją, takie jak uczenie maszynowe, głębokie uczenie, czy przetwarzanie języka naturalnego, umożliwiają maszynom analizowanie dużych ilości danych, rozpoznawanie wzorców, podejmowanie decyzji i wykonywanie złożonych zadań.</p>
            <p>Sztuczna inteligencja ma ogromny potencjał i może zmienić wiele aspektów życia codziennego. Jednakże, istnieją również wyzwania związane z jej rozwojem, takie jak prywatność danych, etyka, czy bezpieczeństwo.</p>
          </article>
      
          <aside>
            <h3>Popularne technologie SI</h3>
            <ul>
              <li>Uczenie maszynowe</li>
              <li>Głębokie uczenie</li>
              <li>Przetwarzanie języka naturalnego</li>
              <li>Robotyka</li>
              <li>Rozpoznawanie obrazów</li>
            </ul>
          </aside>
      
    </div>
   

   
  </section>
  
  
  </html>
  
  <style>

  html {
  scroll-behavior: smooth;
  line-height: 1.6;
   font-family: Arial, sans-serif;
  }

  .napis {
    margin-left: 3%;
    margin-right:3%;
    margin-top:27rem;
    }
    aside {
    color:white;
  padding: 20px;
  border-radius: 5px;
}
  .parallax-item {
  display: flex;
  color:white;
  font-weight: bold;
  font-family: Montserrat, sans-serif;
  width: 100%;
  min-height: 50vh;
  }
  .parallax-item:nth-child(2)
  {
    min-height: 200vh;
  }
  .parallax-item h2 {
  font-size: 3rem;
  text-transform: uppercase;
  color:white;
  padding: 1rem;
  border-radius: 1rem;
  }
  article {
  color:white;
  padding: 20px;
  border-radius: 5px;
  margin-bottom: 20px;
}
  
  .parallax-item:first-child {
  background: url("../../res/defilada.jpg");
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
  

  
  @media screen and (max-width: 768px) {
  .parallax-item h2 {
    font-size: 1rem;
  }
  }
  
  </style>
  

  
  