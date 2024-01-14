
<script>
    export let title;
    export let description;
  </script>
  
  <div class="tile">
    <h2>{title}</h2>
    <p>{description}</p>
  </div>
  
  <style>
    /* Dodaj odpowiedni styl dla kafelków */
    .tile {
      border: 1px solid #ccc;
      padding: 16px;
      margin: 8px;
      border-radius: 8px;
    }
  </style>
