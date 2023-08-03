import React from 'react';
import EmergencyPageLayout from 'components/layout/Page/EmergencyPageLayout/EmergencyPageLayout';
import PageTitle from 'components/atoms/common/PageTitle/PageTitle';
import Capsule from 'assets/icons/pageTitle/Capsule.svg';
import AreaTitle from 'components/atoms/common/AreaTitle/AreaTitle';
import SquareShortcutButton from 'components/atoms/common/SquareShortcutButton/SquareShortcutButton';
import CurrentGreenmateCount from 'components/atoms/emergency/CurrentGreenmateCount/CurrentGreenmateCount';
import TicketInfo from 'components/organisms/emergency/TicketInfo/TicketInfo';

function EmergencyPage() {
	return (
		<EmergencyPageLayout>
			{/* 페이지 헤더 */}
			<PageTitle icon={Capsule} text="응급실" />

			{/* 현재 접속 중인 그린메이트 */}
			<CurrentGreenmateCount />

			{/* 이용권 정보 */}
			<AreaTitle title="이용권 정보" url="#" />
			<TicketInfo />

			{/* 응급실 이용하기 */}
			<AreaTitle title="응급실 이용하기" url="#" />
			<SquareShortcutButton type="consulting-chat" text="채팅 응급실" handleClick={() => {}} />
			<SquareShortcutButton type="consulting-video" text="화상 응급실" handleClick={() => {}} />

			{/* 응급실 이용 내역 */}
			<AreaTitle title="응급실 이용 내역" url="#" />
		</EmergencyPageLayout>
	);
}

export default EmergencyPage;