
<script>
    import { onMount } from 'svelte';
    import Tile from '../lib/layouts/Tile.svelte';
    import Footer from '../lib/sections/Footer.svelte';
    import Navbar from '../lib/sections/Navbar.svelte';
    import { mainColorText, mainColorBorder } from '../stores/ColorStore.js';
  
    mainColorText.set("text-white");
    mainColorBorder.set("border-white");
  
    // Json by się zapisywały
    let tiles = JSON.parse(localStorage.getItem('tiles')) || [];
  
    // Dane formularza
    let newTileTitle = '';
    let newTileDescription = '';
  
    // Dodawanie Kafelków
    function addTile() {
      if (newTileTitle && newTileDescription) { 
        tiles = [...tiles, { title: newTileTitle, description: newTileDescription }];
        localStorage.setItem('tiles', JSON.stringify(tiles));
        newTileTitle = '';
        newTileDescription = '';
      }
    }
  </script>
  
  <style>
    .main-container {
      display: flex;
      flex-direction: column;
      align-items: center; 
      justify-content: center;
      height: 100vh;
    }
  
    /*css grid*/
    .grid-container {
      display: grid;
      grid-template-columns: repeat(2, 1fr);
      
      gap: 16px;
      justify-content: center; /* Wycentruj kafelki w poziomie */
    }
  
    /* Dodaj styl dla formularza */
    .form-container {
      margin-top: 16px;
      text-align: center;
    }
   
  </style>
  
  <Navbar />
  
  <div class="main-container text-4xl font-bold text-white overflow-auto">
    <p>Library</p>
    
    <!-- Wyświetl kafelki za pomocą pętli -->
    <div class="grid-container">
      {#each tiles as { title, description }}
        <Tile {title} {description} />
      {/each}
    </div>
  
    <!-- Formularz dodawania nowych kafelków -->
    <div class="form-container text-white">
      <h2>Dodaj nowy kafelek</h2>
      <form on:submit|preventDefault={addTile}>
        <label for="newTileTitle">Tytuł:</label>
        <input bind:value={newTileTitle} id="newTileTitle" required class="text-black" />
  
        <label for="newTileDescription">Opis:</label>
        <textarea bind:value={newTileDescription} id="newTileDescription" required class="text-black" />
  
        <button type="submit">Dodaj kafelek</button>
      </form>
    </div>
  </div>
  
  <Footer />
  /* dodam do tego by kafelki były normalnie i nie wyłaziły poza stronę */