<script>
    import { onMount } from "svelte";
    import { writable } from 'svelte/store';
  import Footer from "../../lib/sections/Footer.svelte";
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
  parallax.style.backgroundPositionY = offset * -2 + "px";
  // DIV 1 background will move slower than other elements on scroll.
  });
  
        });
        
        


  // DIV 1 background will move slower than other elements on scroll.
  </script>
  <html lang="en">
  <head>
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Montserrat:400,700">
  </head>
  
  <section id="section">
    <div id="parallax" class="parallax-item">
      <h2 class="napis">Historyczny Kalendarz</h2>
    </div>
    <div class="parallax-item">
        <article>
            <h2>mjr. Adolf Plich</h2>
            <p>👉 Z historycznego kalendarza: 22 maja 1914 r., w Wiśle, urodził się mjr Adolf Plich - ps. "Góra" "Dolina" - jeden z najlepszych dowódców oddziałów AK oraz cichociemny. Uczestniczył w ponad 200 starciach z przeciwnikiem, w większości odnosił zwycięstwo.
              Nie został zmobilizowany w 1939 roku, przedostał się jednak do Francji gdzie został wcielony jako oficer do 3 Dywizji Piechoty. Po upadku Francji dotarł do Wielkiej Brytanii gdzie przeszedł szkolenie dywersyjne cichociemnych. Zrzucony do Polski w nocy z 16 na 17 lutego 1943 roku otrzymał przydział do Kedywu Okręgu AK "Czapla" Białystok, a następnie do Okręgu AK "Nów" Nowogródek, działał pod pseudonimem "Góra".</p><br>
            <p>👉 Jako Oficer Zgrupowania Stołpeckiego AK walczył w puszczy Nalibockiej atakując głównie oddziały niemieckie i policję białoruską. W wyniku zdradzieckiej napaści partyzantki sowieckiej oddział polski został rozbity, a cześć partyzantów została wcielona do sowietów. Utworzył oddział składający się z 40 partyzantów, który rozrósł się do 800 w 1944 roku. Chronił wówczas ludzi przed partyzantką sowiecką. </p><br>
            <p>👉 W 1944 roku przedarł się w okolice Warszawy z oddziałem liczącym 861 ludzi i taborem, możliwe było to głównie ze względu na reorganizację niemieckich jednostek. W lipcu 1944 przemianował też pseudonim z "Góry" na "Dolinę" i podporządkował się kpt. Józefowi Krzyczkowskiemu ps. "Szymon" komendantowi VII Rejonu "Łęgów" VII Odwodu "Obroża" Okręgu Warszawskiego AK. W nocy 2-3 września dokonał ataku na batalion SS-RONA rozgramiając go i zabijając 250 rosyjskich esesmanów. Walczył do stycznia 1945 roku, kiedy to ruszyła ofensywa zimowa Armii Czerwonej. W obliczu ofensywy sowieckiej zdecydował się przedostać przez Czechosłowację do Wielkiej Brytanii (do 1954 pracował jako kamieniarz, następnie przy produkcji lodów w firmie „Egec British J. Partners”, od 1979 w dziale finansowym Narodowej Służby Zdrowia), odwiedził kraj w 1990 roku, gdzie został entuzjastycznie przywitany z honorami. Zmarł w 2000 roku na emigracji.</p><br>
          </article>
      
          <aside>
            <h3>Hashtagi:</h3>
            <ul>
              <li>#PamiećHistoryczna</li>
              <li>#AK</li>
        
            </ul>
          </aside>
      
    </div>
   

   
  </section>
  
<Footer/>
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
  color:rgba(255, 255, 255, 0.767);
  font-weight: bold;
  font-family: Montserrat, sans-serif;
  width: 100%;
  min-height: 50vh;
  }
  .parallax-item:nth-child(2)
  { 
    background:linear-gradient(to bottom,rgb(2 6 23),rgb(30 41 59));
    min-height: 10vh;
  }
  .parallax-item h2 {
  font-size: 3rem;
  text-transform: uppercase;
  color:rgba(255, 255, 255, 0.89);
  padding: 1rem;
  border-radius: 1rem;
  }
  article {
  color:rgba(255, 255, 255, 0.897);
  padding: 20px;
  border-radius: 5px;
  margin-bottom: 20px;
}
  
  .parallax-item:first-child {
  background: url("../../res/zdj.jpg");
  background-size: cover;
  zoom:100%;
  background-repeat: no-repeat;
  
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
  
 
  

  
  @media screen and (max-width: 768px) {
  .parallax-item h2 {
    font-size: 1rem;
  }
  }
  
  </style>
  

  
  