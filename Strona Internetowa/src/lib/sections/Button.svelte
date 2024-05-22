<script>
    function toggle() {
        window.document.body.classList.toggle('dark-mode')
        window.HTMLDivElement.classList.toggle('dark-mode')
    }
    </script>
    <button on:click={toggle}>
        <slot/>
    </button>
    <style>
        button {
            background-color: #f76027;
            color: white;
            border: none;
            border-radius: 4px;
            padding: 0.5rem;
            text-transform: uppercase;
            
        }
        :global(body.dark-mode) button {
            background-color: #0084f6;
            color: white;
        }
        :global(body) {
        transition: background-color 0.3s, color 0.3s;
    }
  
    :global(.parallax-item:nth-child(2) .s-eIjPGJ1o5HKT){
      
    }
    :global(.dark-mode) {
        background-color: #661111;
        color: #ffffff;
    }
    :global(body:not(.dark-mode)) {
        background-color: #ffffff;
        color: #000000;
    }
    
    :global(.footer:not(.dark-mode)) {
        background-color: #9e1f1f;
        color: #000000;
    }
    :global(.footer:is(.dark-mode)) {
        background-color: #0b6337;
        color: #000000;
    }
   
    :global(.parallax-item:is(.dark-mode)){
        background-color: #571212;
        color: #000000;
    }
    </style>