<script>
    import Navbar from "../lib/sections/Navbar.svelte";
    import Footer from "../lib/sections/Footer.svelte";
    import { mainColorText, mainColorBorder } from "../stores/ColorStore.js";

    mainColorText.set("text-white");
    mainColorBorder.set("border-white");
</script>

<Navbar />
<div class="h-screen flex flex-col items-center justify-center bg-gradient-to-b from-slate-950 to-slate-800">
    <div class="max-w-md text-center p-8 rounded-lg shadow-lg bg-white bg-opacity-10 backdrop-blur-md">
        <p class="text-2xl font-bold mb-6 text-white">Oto nasze projekty:</p>
        <ul class="text-lg text-white">
            <li class="py-2">Jesteśmy – by pamiętać</li>
            <li class="py-2 border-t border-gray-300">Przelej krew w rocznicę Powstania Warszawskiego</li>
            <li class="py-2 border-t border-gray-300">Centrum Wolontariatu Patriotycznego „Szaniec”</li>
            <li class="py-2 border-t border-gray-300">Instytut Ziem Zachodnich im. Lecha Karola Neymana (do przemyślenia)</li>
            <li class="py-2 border-t border-gray-300">7. Kartka z kalendarza</li>
        </ul>
    </div>
</div>
<Footer />