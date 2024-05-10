<script>
    import {link} from 'svelte-routing';
</script>
<body><div class="cztery">
</div><h1> Error 404 - Not Found</h1>
<a href="/" use:link> go back home</a>
</body>

<style>
    .cztery{
        background-image: url("../res/Polska404.png");
         /* The image used */
   /* Used if the image is unavailable */
  height: 60vh; /* You must set a specified height */
  background-position: center; /* Center the image */
  background-repeat: no-repeat; /* Do not repeat the image */
  background-size: contain;
    }
   a {
        min-height:40vh;
        text-align: center;
        color:white;
        font-size: 3em;
    }
    h1 {
        min-height:37.5vh;
        text-align: center;
        color:white;
        font-size: 3em;
        
    }
    body{
        background:linear-gradient(to bottom,rgb(2 6 23),rgb(30 41 59));
        min-height: 100%;
    }
</style>