<script>
	import { mainColorBorder, mainColorText } from "../../stores/ColorStore";
	
		
	mainColorText.set("text-white");
	mainColorBorder.set("border-white");


</script>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>Completed - NewsFlash | Home</title>
	<!-- Favicon -->
	<link rel="icon" type="image/png" sizes="32x32" href="./assets/images/favicon.png">
	<!-- Remix icons -->
	<link href="https://cdn.jsdelivr.net/npm/remixicon@2.5.0/fonts/remixicon.css" rel="stylesheet">
	<!-- Swiper.js styles -->
	<link rel="stylesheet" href="./assets/css/swiper-bundle.min.css"/>
	<!-- Custom styles -->
	<link rel="stylesheet" href="./assets/css/main.css">
</head>
<body>
<footer class="footer section">
	
	<div class="footer-container container d-grid ">
		
		<div class="company-data">
			<a href="./index.html">
				<h2 class="logo">Fundacja Patriotyczna <br>im. Witolda Pileckiego</h2>
			</a>
			<p class="company-description">Dowiedzieć się więcej o nas możecie na naszych socialach!</p>
			
			<ul class="list social-media">
				<li class="list-item">
					<a href="https://www.instagram.com/jestesmybypamietac/" target="_blank" class="list-link"><i class="ri-instagram-line"></i></a>
				</li>
				<li class="list-item">
					<a href="https://www.facebook.com/jestesmybypamietac2023?locale=pl_PL" target="_blank" class="list-link"><i class="ri-facebook-circle-line"></i></a>
				</li>
				
			</ul>

			<span class="copyright-notice">&copy;2024 Fundacja Patriotyczna <br>im. Witolda Pileckiego</span>
		</div>

		<div>
			<h6 class="title footer-title">Wyszukiwarka</h6>
			
			<ul class="footer-list list">
				<li class="list-item">
					<a href="#" class="list-link">Coś</a>
				</li>
				<li class="list-item">
					<a href="#" class="list-link">Food</a>
				</li>
				<li class="list-item">
					<a href="#" class="list-link">Technology</a>
				</li>
				
			</ul>

		</div>

		<div>
			<h6 class="title footer-title">Artykuły</h6>
			
			<ul class="footer-list list">
				<li class="list-item">
					<a href="#" class="list-link">Home</a>
				</li>
				<li class="list-item">
					<a href="#" class="list-link">Elements</a>
				</li>
				<li class="list-item">
					<a href="#" class="list-link">Tags</a>
				</li>
				<li class="list-item">
					<a href="#" class="list-link">Authors</a>
				</li>
				<li class="list-item">
					<a href="#" class="list-link">Membership</a>
				</li>
			</ul>

		</div>

		<div>
			<h6 class="title footer-title">O nas</h6>
			
			<ul class="footer-list list">
				<li class="list-item">
					<a href="#" class="list-link">Contact us</a>
				</li>
				<li class="list-item">
					<a href="#" class="list-link">F.A.Q</a>
				</li>
				<li class="list-item">
					<a href="#" class="list-link">Careers</a>
				</li>
				<li class="list-item">
					<a href="#" class="list-link">Authors</a>
				</li>
				<li class="list-item">
					<a href="#" class="list-link">Memberships</a>
				</li>
			</ul>

		</div>

	</div>
	
</footer>
</body>
</html>
<style>
	/* Import font */
@import url('https://fonts.googleapis.com/css2?family=Poppins:wght@300;400;600;700&display=swap');


:root{
    --light-color: #fff;
    --light-color-alt: #afb6cd;
    --primary-background-color: linear-gradient(red, green);
    --secondary-background-color: #252830;
    --hover-light-color: var(--light-color);
    --hover-dark-color: var(--primary-background-color);
    --gradient-color: linear-gradient(
        115deg,#4fcf70,#fad648,#a767e5,#12bcfe,#44ce7b);
    --transparent-light-color: rgba(255, 255, 255, 0.212);
    --transparent-dark-color: rgba(0,0,0,.75);
    --font-family: 'Poppins', sans-serif;
    --font-size-xsm: 1.2rem;
    --font-size-sm: 1.6rem;
    --font-size-md: 2.4rem;
    --font-size-lg: 3rem;
    --font-size-xl: 4rem;
    --gap: 2rem;
    --margin-sm: 2rem;
    --margin-md: 3rem;
    --item-min-height-sm: 20rem;
    --item-min-height-md: 30rem;
}

/* Base styles */
*{
    margin: 0;
    padding: 0;
    box-sizing: border-box;
	zoom: 95%;
}

html{
    font-size: 62.5%;
	
}

body{
    font-family: var(--font-family);
    font-size: var(--font-size-sm);
    color: var(--light-color-alt);
    
    letter-spacing: 1px;
    transition: background-color .25s,color .25s;
	
}

a{
    color: inherit;
    text-decoration: none;
}

ul{
    list-style: none;
}



i{
    font-size: var(--font-size-md);
}

/* Reusable classes */
.container{
    max-width: 160rem;
    margin: 0 auto;
    padding: 0 1.5rem;
}



.section:not(.featured-articles){
    padding-block: 5rem;
}

.d-grid{
    display: grid;
}




.logo{
    font-size: var(--font-size-md);
    color: var(--light-color);
}



.list{
    display: flex;
    align-items: center;
    gap: var(--gap);
}


.title{
    color: var(--light-color);
}


/* Footer */
.footer{
    
}


.company-data{
    display: flex;
    flex-direction: column;
    order: 1;
}

.company-description{
    margin-block: var(--margin-sm);
    max-width: 75%;
}

.social-media{
    margin-bottom: var(--margin-md);
}

.copyright-notice{
    opacity: .8;
}

.footer-list{
    flex-direction: column;
    align-items: flex-start;
}

.footer-title{
    font-size: var(--font-size-sm);
    text-transform: uppercase;
    margin-bottom: var(--margin-sm);
}

/* Scrollbar */
::-webkit-scrollbar {
    width: 1rem;
}
  
::-webkit-scrollbar-track {
    background: #f1f1f1;
}
  
::-webkit-scrollbar-thumb {
    background: #3f4254;
}
  
::-webkit-scrollbar-thumb:hover {
    background: #2e303b;
}


@media screen and (min-width: 700px) {

    
   

    .company-data{
        order: 0;
    }

    
}

@media screen and (min-width: 768px) {

   

  
}

@media screen and (min-width: 1024px) {


    @keyframes animate_border{
        to{
            transform:translateX(-50%)
        }
    }




    .footer-container{
        grid-template-columns: repeat(5, 1fr);
        
    }

    .company-data{
        grid-column: span 2;
    }

    .company-description{
        max-width: 85%;
    }

    .copyright-notice{
        margin-top: auto;
    }

   
}

@media screen and (min-width: 1200px) {
    
}
@media screen and (min-width: 1500px) {
   

}
</style>