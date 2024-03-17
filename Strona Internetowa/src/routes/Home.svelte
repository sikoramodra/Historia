<script>
    import { slide } from 'svelte/transition';
    import { onMount } from "svelte";
    import { writable } from 'svelte/store';
    import Footer from '../lib/sections/Footer.svelte';
    import Navbar from '../lib/sections/Navbar.svelte';
    import { mainColorBorder, mainColorText } from '../stores/ColorStore.js';
    import Div from './Div.svelte';
    
  //import Scrollbar from 'smooth-scrollbar'

  import Scroll from './Scroll.svelte'
 /* import Attribution from './components/Attribution.svelte'
  import Hero from './containers/Hero.svelte'
  import Divider from './components/Divider.svelte'
  import Feature from './containers/Feature.svelte'
  

  import { initAnimations } from './scripts/animations'
*/
  let showScroll = true
    mainColorText.set("text-white");
    mainColorBorder.set("border-white");

</script>

<Navbar/>
<Div/>
<Footer/>