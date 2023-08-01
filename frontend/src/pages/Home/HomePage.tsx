import HomePageLayout from 'components/layout/HomePageLayout/HomePageLayout';
import AreaTitle from 'components/atoms/common/AreaTitle/AreaTitle';
import SubscribeSlider from 'components/organisms/subscribe/SubscribeSlider/SubscribeSlider';
import React from 'react';
import BannerSlider from 'components/organisms/common/BannerSlider/BannerSlider';
import SquareShortcutButton from 'components/atoms/common/SquareShortcutButton/SquareShortcutButton';
import RectShortcutButton from 'components/atoms/common/RectShortcutButton/RectShortcutButton';

function HomePage() {
	return (
		<HomePageLayout>
			<BannerSlider />
			<AreaTitle title="내 구독 정보" url="subscribe" />
			<SubscribeSlider />
			<AreaTitle title="서비스 바로가기" url="#" />
			<SquareShortcutButton
				message="예약관리"
				onClick={() => {
					alert('예약관리로 이동');
				}}
				type="booking"
			/>
			<RectShortcutButton
				message="채팅 컨설팅"
				onClick={() => {
					alert('채팅상담');
				}}
				type="consulting-chat"
			/>
			<RectShortcutButton
				message="화상 컨설팅"
				onClick={() => {
					alert('화상상담');
				}}
				type="consulting-video"
			/>
			<AreaTitle title="구독샵" url="/shop" />
		</HomePageLayout>
	);
}

export default HomePage;
