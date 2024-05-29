<script>
	import Navbar from "../lib/sections/Navbar.svelte";

	import { Link } from "svelte-routing";
</script>

<Navbar />
<html lang="en">
	<body>
		<div class="linki grid-container">
			<div class="card">
				<Link to="/library/jogurt"
					><article class="grid-item">
						<div class="card__header">
							<img src="src/res/Zdjęcie Spotkanie.jpg" alt="card__image" class="card__image" width="600" />
						</div>
						<div class="card__body">
							<span class="tag tag-blue"></span>
							<h4>W Hołdzie Powstańcom Wielkopolskim</h4>
							<p>
								W sobotę, 17 lutego, złożyliśmy hołd Bohaterom Powstania Wielkopolskiego - powstańcom i żołnierzom, którzy 105 lat
								temu chwycili za broń i doprowadzili do największego polskiego zwycięskiego powstania!
							</p>
						</div>
						<data>17.02.2024</data>
					</article></Link
				>
			</div>

			<div class="card">
				<Link to="/library/historycznykalendarz"
					><article class="grid-item">
						<div class="card__header">
							<div class="img"></div>
						</div>
						<div class="card__body">
							<span class="tag tag-blue"></span>
							<h4>Historyczny Kalendarz</h4>
							<p>
								👉Z historycznego kalendarza: 22 maja 1914 r., w Wiśle, urodził się mjr Adolf Plich - ps. "Góra" "Dolina" - jeden z
								najlepszych dowódców oddziałów AK oraz cichociemny. Uczestniczył w ponad 200 starciach z przeciwnikiem, w większości
								odnosił zwycięstwo.
							</p>
						</div>
						<data>14.02.2024</data>
					</article></Link
				>
			</div>
			<div class="card">
				<Link to="/library/inny-artykul"
					><article class="grid-item">
						<div class="card__header">
							<img src="src/res/Zdjęcie Spotkanie.jpg" alt="card__image" class="card__image" width="600" />
						</div>
						<div class="card__body">
							<span class="tag tag-blue"></span>
							<h4>Wielkopolskiego</h4>
							<p>
								W sobotę, 17 lutego, złożyliśmy hołd Bohaterom Powstania Wielkopolskiego - powstańcom i żołnierzom, którzy 105 lat
								temu chwycili za broń i doprowadzili do największego polskiego zwycięskiego powstania!
							</p>
						</div>
						<data>17.02.2024</data>
					</article></Link
				>
			</div>
			<div class="card">
				<Link to="/library/inny-artykul"
					><article class="grid-item">
						<div class="card__header">
							<img src="src/res/Zdjęcie Spotkanie.jpg" alt="card__image" class="card__image" width="600" />
						</div>
						<div class="card__body">
							<span class="tag tag-blue"></span>
							<h4>Spotkanie drugie</h4>
							<p>
								W sobotę, 17 lutego, złożyliśmy hołd Bohaterom Powstania Wielkopolskiego - powstańcom i żołnierzom, którzy 105 lat
								temu chwycili za broń i doprowadzili do największego polskiego zwycięskiego powstania!
							</p>
						</div>
						<data>13.02.2024</data>
					</article></Link
				>
			</div>

			<div class="card">
				<Link to="/library/inny-artykul"
					><article class="grid-item">
						<div class="card__header">
							<img src="src/res/Zdjęcie Spotkanie.jpg" alt="card__image" class="card__image" width="600" />
						</div>
						<div class="card__body">
							<span class="tag tag-blue"></span>
							<h4>Wyjście w niedziele</h4>
							<p>
								W sobotę, 17 lutego, złożyliśmy hołd Bohaterom Powstania Wielkopolskiego - powstańcom i żołnierzom, którzy 105 lat
								temu chwycili za broń i doprowadzili do największego polskiego zwycięskiego powstania!
							</p>
						</div>
						<data>16.02.2024</data>
					</article></Link
				>
			</div>

			<div class="card">
				<Link to="/library/inny-artykul"
					><article class="grid-item">
						<div class="card__header">
							<img src="src/res/Zdjęcie Spotkanie.jpg" alt="card__image" class="card__image" width="600" />
						</div>
						<div class="card__body">
							<span class="tag tag-blue"></span>
							<h4>Spotkanie</h4>
							<p>
								W sobotę, 17 lutego, złożyliśmy hołd Bohaterom Powstania Wielkopolskiego - powstańcom i żołnierzom, którzy 105 lat
								temu chwycili za broń i doprowadzili do największego polskiego zwycięskiego powstania!
							</p>
						</div>
						<data>21.02.2024</data>
					</article></Link
				>
			</div>
		</div>
	</body></html
>

<style>
	.card {
		display: flex;
		flex-direction: column;
		width: clamp(20rem, calc(20rem + 2vw), 22rem);
		overflow: hidden;
		box-shadow: 0 0.1rem 1rem rgba(0, 0, 0, 0.1);
		border-radius: 1em;
		background: #ece9e6;
		background: linear-gradient(to right, #ffffff, #ece9e6);
	}
	.card__body {
		padding: 1rem;
		display: flex;
		flex-direction: column;
		gap: 0.5rem;
		z-index: 100;
	}
	.card__body h4 {
		font-size: 1.5rem;
		text-transform: capitalize;
	}
	data {
		font-size: 0.8rem;
		float: right;
		margin-right: 5%;
		margin-bottom: 1%;
		position: flex;
	}
	body {
		width: 100%;
	}
	.linki {
		margin-top: 100px;
		width: 100%;
	}

	html {
		position: absolute;
		min-height: 100%;
		min-width: 100%;
		background: linear-gradient(to bottom, rgb(2 6 23), rgb(30 41 59));
	}
	.grid-container {
		zoom: 90%;
		display: grid;
		gap: 50px 50px;
		grid-template-columns: auto auto auto;
		max-width: 120vh;
		margin-left: auto;
		margin-right: auto;
		padding: 10px;
		margin-top: 30vh;
	}
	.card__header:nth-child(1) {
		min-height: 300px;
		max-height: 300px;
	}
	.img {
		min-height: 300px;
		max-height: 200px;
		background-repeat: no-repeat;
		background: url("../res/zdj.jpg");
		background-size: cover;
		background-position: center center;
	}
</style>
